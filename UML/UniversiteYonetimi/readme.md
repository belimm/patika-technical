# Üniversite Sınıf Diyagramı

![UML Diyagram](./University_System_UML.svg)


UML class diagram olarak modellenmiş basit bir üniversite sistemi.

## Sınıflar

- **Üniversite** — Sınıflıkları, ofisleri ve departmanları bünyesinde barındırır.
- **Departman** — Üniversiteye bağlıdır; kendine ait ofisleri vardır.
- **Ofis** — Çalışma ofisi. Hem üniversiteye hem de bir departmana bağlı olabilir.
- **Sınıflık** — Üniversiteye ait ders mekanı.
- **Çalışan** *(abstract)* — Üniversitede görev yapan kişi. Profesör veya Memur olarak somutlaşır.
- **Profesör** — Çalışan alt sınıfı.
- **Memur** — Çalışan alt sınıfı.

## İlişkiler

| İlişki | Tip | Çokluk |
|---|---|---|
| Üniversite → Departman | Composition | 1 — * |
| Üniversite → Sınıflık | Composition | 1 — * |
| Üniversite → Ofis | Composition | 1 — * |
| Departman → Ofis | Aggregation | 1 — * |
| Üniversite → Çalışan | Association (çalıştırır) | 1 — * |
| Çalışan → Ofis | Association (çalışır) | * — 1 |
| Çalışan ← Profesör | Generalization | — |
| Çalışan ← Memur | Generalization | — |
