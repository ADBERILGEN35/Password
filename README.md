# Password Generator Projesi

Bu proje, rastgele şifreler oluşturmanızı ve bu şifreleri veritabanına kaydetmenizi sağlar. Ayrıca oluşturulan şifreleri listeleyebilirsiniz.

## Teknolojiler
Proje aşağıdaki teknolojileri kullanır:
- Java 8
- Spring Boot
- H2 Veritabanı
- Spring Data JPA
- Lombok

## Proje Açıklaması

### Veritabanı Modeli
- `PasswordModel` adında bir JPA varlığı kullanılarak veritabanına şifreler kaydedilir. Bu varlık `generatedPassword` adında şifreyi tutan bir alan içerir.

### Veritabanı Bağlantısı
- Veritabanı bağlantısı için H2 gömülü veritabanı kullanılır. `H2DatabaseConnection` sınıfı, tek bir bağlantı örneği üzerinden bağlantı sağlar.

### Şifre Oluşturma
- `PasswordGeneratorServiceImpl` sınıfı, rastgele şifre oluşturma işlevini gerçekleştirir. Şifre, kullanıcının isteğine göre rastgele harf, rakam ve sembollerle oluşturulur.

### Şifreleri Listeleme
- `PasswordGeneratorService` arayüzü üzerinden şifrelerin listelenmesi sağlanır. Bu işlev `PasswordGeneratorController` sınıfı üzerinden kullanıcı tarafından erişilebilir.

## Nasıl Kullanılır

Proje şifre oluşturma ve listeleme için API sağlar. Aşağıda temel kullanım adımları bulunmaktadır:

1. Şifre Oluşturma
   - `POST /password/generate` yolunu kullanarak rastgele bir şifre oluşturabilirsiniz. İstek gövdesi `GeneratorDto` kullanır.

2. Şifreleri Listeleme
   - `GET /password/passwords` yolunu kullanarak veritabanındaki şifreleri listeleyebilirsiniz.

