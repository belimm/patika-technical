# Online Film Satış ve Kiralama Sistemi — UML Sınıf Diyagramı

![UML Diyagram](./Movie_Management_UML.svg)


Bu doküman, online film satışı ve kiralama uygulamasının nesne yönelimli tasarımını açıklamaktadır. Sistem; kullanıcı yönetimi, abonelik, kredi işlemleri, film satışı/kiralama ve film talep mekanizmalarını kapsamaktadır.

---

## Sınıflar

### User
Sistemdeki tüm kullanıcıları temsil eder. Normal kullanıcılar ve aboneler bu sınıftan türer. Her kullanıcının benzersiz bir kimliği (`userId`), adı, e-posta adresi ve rolü (`role`) vardır. Rol değeri `{user, subscriber}` enum'undan birini alır.

**Yetenekleri:**
- Film listesini görüntüleyebilir ve sıralayabilir.
- Film satın alabilir.
- Mevcut olmayan filmler için talepte bulunabilir (`MovieRequest`).

### Subscriber
`User` sınıfından türeyen alt sınıftır. Aboneliği olan kullanıcıları temsil eder. Normal kullanıcıların yapamadığı şu işlemleri gerçekleştirebilir:

- **Kredi satın alma:** Sistem üzerinden kredi yükler; her işlem `CreditTransaction` olarak kaydedilir.
- **Film kiralama:** Kredi bakiyesi (`creditBalance`) yeterli olduğunda film kiralayabilir. Kiralama işlemi sonunda filmin kredi bedeli kadar bakiyesi azalır.

### Subscription
Abonelik sözleşmesini temsil eder. Her aboneliğin benzersiz bir kimliği, başlangıç ve bitiş tarihi bulunur. `Subscriber` ile composition ilişkisi içindedir; abone olmadan abonelik de anlamsızdır.

### CreditTransaction
Bir abonenin kredi yükleme işlemini temsil eder. Her işlemde yüklenen miktar (`amount`) ve tarih (`date`) kaydedilir. Bir aboneye ait birden fazla kredi işlemi olabilir.

### Movie
Sistemde listelenen filmleri temsil eder. Her filmin benzersiz kimliği, başlığı, türü, kiralama fiyatı (`rentalPrice`), satış fiyatı (`salePrice`) ve müsaitlik durumu (`isAvailable`) vardır. Film müsait değilse kullanıcılar `MovieRequest` oluşturabilir.

### Purchase
Bir kullanıcının film satın alma işlemini temsil eder. Hem normal kullanıcılar hem de aboneler satın alma yapabilir. İşlem tarihi ve ödenen tutar (`amountPaid`) kaydedilir.

### Rental
Abonenin kredi karşılığında film kiraladığı işlemi temsil eder. Kiralama tarihine ek olarak düşülen kredi miktarı (`creditCharged`) tutulur. Yalnızca `Subscriber` rolündeki kullanıcılar kiralama yapabilir.

### MovieRequest
Kullanıcının mevcut olmayan bir filmi talep etmesini temsil eder. Talep edilen filmin başlığı (`requestedTitle`) ve talep tarihi saklanır. Hem normal kullanıcılar hem de aboneler talepte bulunabilir.

---

## İlişkiler

| İlişki | Tip | Çokluk | Açıklama |
|---|---|---|---|
| User ← Subscriber | Generalization | — | Subscriber, User'ın özelleşmiş halidir |
| Subscriber → Subscription | Composition | 1 — 1 | Her abonenin bir aboneliği vardır |
| Subscriber → CreditTransaction | Aggregation | 1 — * | Bir abonenin birden fazla kredi işlemi olabilir |
| User → Purchase | Association | 1 — * | Kullanıcı birden fazla film satın alabilir |
| Subscriber → Rental | Association | 1 — * | Abone birden fazla film kiralayabilir |
| User → MovieRequest | Association | 1 — * | Kullanıcı birden fazla film talebinde bulunabilir |
| Movie → Purchase | Association | 1 — * | Bir film birden fazla kez satın alınabilir |
| Movie → Rental | Association | 1 — * | Bir film birden fazla kez kiralanabilir |

---

## Tasarım Kararları

**Generalization (Kalıtım):** `Subscriber`, `User`'dan türetildi. Ortak nitelikler (`userId`, `name`, `email`) üst sınıfta tutulurken aboneye özgü nitelikler (`creditBalance`, `subscription`) alt sınıfta tanımlandı. Bu sayede kod tekrarı önlenir ve `role` enum'u her zaman nesnenin gerçek tipini yansıtır.

**Composition vs Aggregation:** `Subscriber` ile `Subscription` arasında composition kullanıldı; abone silindiğinde aboneliği de sona ermelidir. `CreditTransaction` ise aggregation ile modellendi; işlem geçmişinin bağımsız olarak da sorgulanabilmesi gerekebilir.

**Purchase hem User hem Subscriber için geçerli:** Satın alma yeteneği yalnızca abonelere değil tüm kullanıcılara açık olduğundan `Purchase` ilişkisi `User` üzerinden kuruldu. Kalıtım sayesinde `Subscriber` nesneleri bu ilişkiyi otomatik olarak devralır.

**Rental yalnızca Subscriber'a bağlı:** Kiralama işlemi kredi gerektirir; kredi yalnızca abonelerde bulunur. Bu yüzden `Rental` doğrudan `Subscriber`'a bağlandı.

**MovieRequest her iki kullanıcı tipine açık:** Film talebi abonelik gerektirmez; `User` üzerinden modellenerek tüm kullanıcılara açık hale getirildi.

**`isAvailable` bayrağı:** Bir filmin talep edilip edilemeyeceği bu boolean değerle kontrol edilir. `false` olduğunda kullanıcıya `MovieRequest` seçeneği sunulur.
