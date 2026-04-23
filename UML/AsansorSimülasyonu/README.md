# Asansör Simülatörü — UML Sınıf Diyagramı

![UML Diyagram](./Elevator_Simulator_UML.svg)

Bu doküman, Kodluyoruz Sigorta Şirketi'nin 12 katlı ofis binası için tasarlanan asansör simülatörünün nesne yönelimli tasarımını açıklamaktadır. Diyagram; Kapsülleme, Kalıtım, Çok Biçimlilik ve Soyutlama ilkelerini gözetilerek oluşturulmuştur.

---

## OOP İlkeleri

| İlke | Uygulandığı Yer |
|---|---|
| **Encapsulation** | Tüm sınıflarda nitelikler `private (-)` tanımlandı; davranışlar `public (+)` metodlarla sunuldu |
| **Inheritance** | `Button`, `SignalLight`, `Door` soyut sınıflardan türetilen alt sınıflar |
| **Polymorphism** | `open()`, `press()`, `illuminate()` gibi metodlar her alt sınıfta farklı davranır |
| **Abstraction** | `Button`, `SignalLight`, `Door` soyut (`«abstract»`) olarak tanımlandı; doğrudan örneklenemezler |

---

## Sınıflar

### Simulator
Simülasyonun giriş noktasıdır. `Clock`, `Building` ve `RandomGenerator` nesnelerini yönetir. Simülasyon boyunca gerçekleşen olayları zaman damgasıyla `eventLog` listesine kaydeder.

### Clock
Gerçek zaman geçişini simüle eder. Her tick, sistemdeki tüm bileşenlerin bir adım ilerlemesini tetikler. `tickInterval` değeri simülasyon hızını belirler.

### Building
12 katlı binayı temsil eder. 5 `Elevator` ve 12 `Floor` nesnesini composition ile bünyesinde tutar; bina olmadan bunlar var olamaz.

### Floor
Her kattaki fiziksel ortamı temsil eder. Her katta 5 asansör boşluğuna karşılık gelen 5 adet `FloorDoor` ve 3 set çağrı düğmesi (`CallButton`) bulunur.

### Elevator
Asansörün kendisini temsil eder. Kapasitesi 6 yolcudur. Durumu `{idle, moving, open}` enum değerlerinden birini alır. Her asansörde bir `ControlPanel`, bir `ElevatorDoor` ve içindeki yolcuları bilgilendiren bir `FloorIndicator` bulunur.

### ControlPanel
Asansörün içindeki kontrol panosu. Kapı açma/kapama düğmeleri, acil durum butonu ve hedef kat düğmelerini (`DestinationButton`) barındırır.

### Scheduler
Çağrı düğmesine basıldığında hangi asansörün ilgili kata gönderileceğini belirleyen programlayıcı. Algoritma tabanlı çalışır; bekleyen çağrıları bir kuyrukta (`pendingCalls`) yönetir.

### Passenger
Simülatör tarafından rastgele üretilen yolcuyu temsil eder. Kalkış katı (`originFloor`) ve varış katı (`destinationFloor`) `RandomGenerator` tarafından belirlenir.

### RandomGenerator
Yolcu oluşturma ve kat seçiminde rastgelelik sağlar. `seed` değeri ile tekrarlanabilir simülasyonlar mümkündür.

---

## Soyut Sınıflar ve Alt Sınıfları

### Button *(abstract)*
Tüm buton türlerinin ortak davranışını tanımlar. `isPressed` ve `label` nitelikleri üst sınıfta tutulur.

| Alt Sınıf | Açıklama |
|---|---|
| `CallButton` | Katlardaki çağrı düğmesi. Yön bilgisi (`UP`, `DOWN`, `BOTH`) taşır |
| `DestinationButton` | Asansör içindeki hedef kat düğmesi. `targetFloor` değeri taşır |

### SignalLight *(abstract)*
Işık göstergelerinin ortak yapısını tanımlar.

| Alt Sınıf | Açıklama |
|---|---|
| `FloorIndicator` | Asansör içindeki kat gösterge ışığı. Yolcuları mevcut kat hakkında bilgilendirir |
| `DirectionLight` | Kat kapısının üzerindeki sinyal ışığı. Asansörün gelişini ve hareket yönünü gösterir |

### Door *(abstract)*
Tüm kapı türlerinin ortak davranışını tanımlar. `openDuration` ile kapının açık kalacağı süre belirlenir.

| Alt Sınıf | Açıklama |
|---|---|
| `ElevatorDoor` | Asansörün kendi kapısı |
| `FloorDoor` | Her kattaki asansör boşluğu kapısı. Üzerinde `DirectionLight` ve bir `ArrivalBell` bulunur |

### ArrivalBell
Asansörün bir kata ulaştığını bildiren varış zili. Her `FloorDoor` ile composition ilişkisi içindedir.

---

## İlişkiler

| İlişki | Tip | Çokluk | Açıklama |
|---|---|---|---|
| Simulator → Clock | Composition | 1 — 1 | Simülatör saati yönetir |
| Simulator → Building | Composition | 1 — 1 | Simülatör binayı yönetir |
| Simulator → RandomGenerator | Composition | 1 — 1 | Rastgele üreteci yönetir |
| Simulator → Scheduler | Association | 1 — 1 | Programlayıcıya erişir |
| Building → Floor | Composition | 1 — 12 | 12 kat |
| Building → Elevator | Composition | 1 — 5 | 5 asansör |
| Floor → FloorDoor | Composition | 1 — 5 | Her katta 5 kapı |
| Floor → CallButton | Aggregation | 1 — 3 | Her katta 3 çağrı butonu |
| Elevator → ControlPanel | Composition | 1 — 1 | Her asansörde bir kontrol paneli |
| Elevator → ElevatorDoor | Composition | 1 — 1 | Her asansörde bir kapı |
| Elevator → FloorIndicator | Composition | 1 — 1 | Her asansörde kat göstergesi |
| Elevator → Passenger | Association | 0 — 6 | Asansördeki yolcular (max 6) |
| Scheduler → Elevator | Association | 1 — 5 | Asansörleri yönlendirir |
| ControlPanel → DestinationButton | Aggregation | 1 — * | Hedef kat düğmeleri |
| FloorDoor → DirectionLight | Composition | 1 — 1 | Kapı üstündeki yön ışığı |
| FloorDoor → ArrivalBell | Composition | 1 — 1 | Varış zili |
| Button ← CallButton | Generalization | — | Kalıtım |
| Button ← DestinationButton | Generalization | — | Kalıtım |
| SignalLight ← FloorIndicator | Generalization | — | Kalıtım |
| SignalLight ← DirectionLight | Generalization | — | Kalıtım |
| Door ← ElevatorDoor | Generalization | — | Kalıtım |
| Door ← FloorDoor | Generalization | — | Kalıtım |

---

## Tasarım Kararları

**`Button`, `SignalLight`, `Door` soyut sınıf olarak tasarlandı.** Her üç sınıf da doğrudan örneklenmez; yalnızca alt sınıfları somut nesneler oluşturur. Bu, Abstraction ve Polymorphism ilkelerini doğrudan uygular: örneğin `door.open()` çağrısı, kapının türüne göre (`ElevatorDoor` veya `FloorDoor`) farklı davranır.

**Composition tercih edilen durumlarda:** `Building` → `Elevator`, `Floor`, `Elevator` → `ControlPanel`, `ElevatorDoor`, `FloorDoor` → `ArrivalBell` gibi ilişkilerde composition kullanıldı. Bu bileşenler sahip oldukları nesne olmadan anlamsızdır.

**Aggregation tercih edilen durumlarda:** `CallButton` ve `DestinationButton` nesneleri katsayıları nedeniyle aggregation ile modellendi; kavramsal olarak bağımsız var olabilirler.

**`Scheduler` ayrı sınıf olarak modellendi.** Programlama algoritması (`FCFS`, `SCAN` vb.) ilerleyen süreçte değiştirilebilir; bu ayrım Strategy tasarım desenine kapı aralar.

**`Passenger` simülatör tarafından üretilir.** `RandomGenerator` → `Simulator` → `Passenger` zinciri, gerçek dünya trafik akışını simüle eder. Her yolcunun `originFloor` ve `destinationFloor` değerleri rastgele belirlenir.
