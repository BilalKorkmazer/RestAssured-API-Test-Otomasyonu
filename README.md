# 🚀 RestAssured ile REST API Test Otomasyonu

Bu depo, **Swagger Petstore API** üzerinde **Java** ve **RestAssured** kütüphanesi kullanılarak yazılmış otomatik test senaryolarını ve konuyla ilgili hazırlanmış teknik sunum dosyasını içermektedir.

Projeyle, API uç noktalarının (endpoints) manuel olarak test edilmesi yerine, sürekli entegrasyona (CI/CD) uygun, hızlı ve tekrar edilebilir bir test otomasyon mimarisinin nasıl kurulacağı hedeflenmiştir.

## 🛠️ Kullanılan Teknolojiler

* **Java:** Temel programlama dili.
* **Maven:** Proje ve bağımlılık (kütüphane) yönetimi.
* **RestAssured:** HTTP istekleri (GET, POST vb.) oluşturmak ve API yanıtlarını doğrulamak için kullanılan ana test kütüphanesi.
* **JUnit 5 (Jupiter):** Test motoru ve senaryo çalıştırıcı.
* **Hamcrest:** Yanıt (Response) gövdesindeki verileri doğrulamak için kullanılan *Matcher* kütüphanesi.
* **Eclipse IDE:** Geliştirme ortamı.

## 📝 Test Senaryoları

Proje içerisindeki `SwaggerApiTest.java` sınıfı şu iki temel senaryoyu otomatize etmektedir:

1.  **GET İsteği ile Veri Çekme (`/pet/findByStatus`):**
    * Sistemdeki "available" (müsait) durumdaki kayıtlar filtrelenir.
    * Dönen HTTP 200 Başarı kodu, milisaniye cinsinden yanıt süresi ve JSON içerisindeki ilk kaydın statüsü test edilir.
2.  **POST İsteği ile Yeni Kayıt Oluşturma (`/pet`):**
    * Sisteme iç içe geçmiş (nested) JSON formatında, kategori ve etiketleri özel olarak belirlenmiş yeni bir "Sumo Robot" kaydı gönderilir.
    * Sunucunun kayıt işlemine verdiği 200 durumu ile birlikte, dönen verideki `id`, `name` ve alt kırılımdaki `category.name` değerlerinin eşleşip eşleşmediği doğrulanır.

## ⚙️ Projeyi Bilgisayarında Çalıştırma

Bu projeyi kendi bilgisayarında denemek istersen şu adımları izleyebilirsin:

1.  Bu depoyu bilgisayarına indir veya klonla:
    ```bash
    git clone [https://github.com/KullaniciAdin/RestAssured-API-Test-Otomasyonu.git](https://github.com/KullaniciAdin/RestAssured-API-Test-Otomasyonu.git)
    ```
    *(Not: Yukarıdaki linki kendi deponun linkiyle değiştirmeyi unutma!)*
2.  **Eclipse IDE**'yi açın ve sol üst menüden `File > Import > Existing Maven Projects` yolunu izleyerek indirdiğiniz klasörü seçin.
3.  Proje yüklendikten sonra `pom.xml` dosyasındaki kütüphanelerin otomatik inmesini bekleyin. (Eğer hata alırsanız projeye sağ tıklayıp `Maven > Update Project` diyerek zorunlu güncelleme yapabilirsiniz).
4.  `src/test/java/api/tests/SwaggerApiTest.java` dosyasına sağ tıklayın ve **`Run As > JUnit Test`** seçeneğine tıklayarak testleri çalıştırın.
5.  Eclipse konsolunda yeşil çubuğu (Green Bar) ve sunucudan dönen log kayıtlarını göreceksiniz.

## 📊 Sunum Dosyası

Depoda yer alan **`RestAssured-ile-REST-API-Test-Otomasyonu.pdf`** dosyası, bu projenin adım adım nasıl oluşturulduğunu, API testinin önemini ve RestAssured'ın "Given-When-Then" mantığını anlatan 5 dakikalık bir teknik sunumdur. İnceleyebilirsiniz.
