# Hayvanat Bahcesi Hayvan Sistemi

![UML Diyagram](./zoo_animal_class.svg)

Polimorfizm tabanli OOP tasarimi. Her hayvan grubu `getDosage()` ve `getFeedSchedule()` metodlarini kendi algoritmasiyla implement eder.

---

## Erisim Belirleyicileri

| Sembol | Anlam | Kim erisebilir |
|--------|-------|----------------|
| `-` | private | Sadece tanimlandigi sinif |
| `#` | protected | Sinif + tum alt siniflar |
| `+` | public | Her yer |

`weight`, `age`, `speciesName` alanlari `#` (protected) cunku `Tiger.getDosage()` gibi alt sinif metodlari bu alanlara dogrudan erisip hesaplama yapar. `private` olsaydi derleme hatasi alirdik.

---

## Siniflar

### Animal — Soyut Temel Sinif

Tum hayvanlarin ortak ozelliklerini tasir. Dogrudan orneklenemez.

```
# speciesName : String   — Tur adi
# weight      : double   — Agirlik (kg)
# age         : int      — Yas
+ getDosage()            — {abstract}
+ getFeedSchedule()      — {abstract}
```

### Equine — Atlar Grubu

`Animal`'dan miras alir. At grubuna ozgu doz ve yemleme algoritmasi uygular.

```
# hoofSize : double   — Toynak boyutu
```

Alt siniflar: `Horse`, `Zebra`, `Donkey`

### Feline — Kedigiller Grubu

`Animal`'dan miras alir. Et bazli beslenme ve yuksek doz katsayisi vardir.

```
# clawLength : double   — Pence uzunlugu
```

Alt siniflar: `Tiger`, `Lion`

### Rodent — Kemirgenler Grubu

`Animal`'dan miras alir. Kucuk vucut yapisi nedeniyle doz katsayisi en dusuktur.

```
# furDensity : int   — Kursak yogunlugu
```

Alt siniflar: `Rat`, `Beaver`

### Somut Siniflar

| Sinif | Grup | Ozel Alan |
|-------|------|-----------|
| Horse | Equine | `breed: String` |
| Zebra | Equine | `stripeCount: int` |
| Donkey | Equine | `loadCapacity: double` |
| Tiger | Feline | `subspecies: String` |
| Lion | Feline | `maneColor: String` |
| Rat | Rodent | `tailLength: double` |
| Beaver | Rodent | `damBuilt: boolean` |

---

## Polimorfizm — Java Ornegi

```java
Animal[] animals = {
    new Horse("Spirit", 450.0, 6, 28.0, "Arap"),
    new Tiger("Shere Khan", 190.0, 4, 12.0, "Bengal"),
    new Rat("Jerry", 0.3, 2, 8, 18.0)
};

for (Animal a : animals) {
    System.out.println(a.speciesName);
    System.out.println("  Doz     : " + a.getDosage() + " mg");
    System.out.println("  Yemleme : " + a.getFeedSchedule());
}
```

Cikti:

```
Spirit
  Doz     : 9.0 mg          // 450 * 0.02 — Equine formulu
  Yemleme : Sabah 07:00 - Aksam 18:00 (saman + yulaf)

Shere Khan
  Doz     : 9.5 mg          // 190 * 0.05 — Feline formulu
  Yemleme : Sabah 06:00 - Aksam 20:00 (et bazli)

Jerry
  Doz     : 0.024 mg        // 0.3 * 0.08 — Rodent formulu
  Yemleme : Gunde 3 ogun: 08:00 - 13:00 - 19:00 (tahil + sebze)
```

`a.getDosage()` satiri her dongu adiminda aynidir. Ama JVM calisma zamaninda nesnenin gercek turune bakar ve o sinifin metodunu calistirir. Yeni bir grup eklemek icin sadece yeni bir alt sinif yazmak yeterlidir — `ZooManager` kodu degismez.


