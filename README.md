# MyComposeApp
Compose practice
<ol>
  <li>
    <strong>Modüller:</strong> Projemde mantıksal olarak bölünmüş modüller kullandım. Bu modüller, farklı işlevlere veya bileşenlere sahip olabilir ve ayrı iş mantıklarında çalışarak test edilebilirliği kolaylaştırır.
  </li>
  <li>
    <strong>Bağımlılık Enjeksiyonu:</strong> Dagger Hilt kütüphanesini kullanarak bağımlılıkları enjekte ettim ve bileşenler arasında gevşek bağımlılıklar oluşturdum. Bu sayede kodun daha sürdürülebilir, test edilebilir ve esnek olmasını sağladım.
  </li>
  <li>
    <strong>MVVM Mimarisi:</strong> Projede SOLID prensiplerini kullanarak Clean Architecture düzeninde kodlar yazdım. MVVM (Model-View-ViewModel) tasarım desenini kullanarak iş mantığını ve kullanıcı arayüzünü birbirinden bağımsız hale getirdim. Bu sayede kodun yeniden kullanılabilirliğini ve bakımını kolaylaştırdım.
  </li>
  <li>
    <strong>Jetpack Compose:</strong> Kullanıcı arayüzünü programatik olarak oluşturmak için Jetpack Compose yapısını kullandım. Compose, bildirimsel bir yaklaşım sunarak kullanıcı arayüzünü daha kolay bir şekilde tasarlamanıza ve yönetmenize olanak sağlar. Bileşenleri kodla oluşturarak dinamik ve etkileşimli arayüzler oluşturdum.
  </li>
  <li>
    <strong>Retrofit:</strong> API ile etkileşim kurmak için Retrofit kütüphanesini kullandım. Retrofit, HTTP tabanlı bir servis istemcisi kütüphanesi olup, API isteklerini oluşturmayı, yanıtları işlemeyi ve verileri almayı sağlar. Bu sayede API'lerle kolayca iletişim kurabildim ve veri alışverişini yönetebildim.
  </li>
  <li>
    <strong>Coroutine:</strong> Retrofit gibi kütüphanelerle asenkron işlemleri daha okunabilir ve yönetilebilir hale getiren Coroutine yapısını kullandım. Coroutine'leri kullanarak asenkron işlemleri kolayca yönetebilir, arka planda çalışan işlemleri takip edebilir ve UI thread'ini bloke etmeden veri alışverişini gerçekleştirebilirsiniz.
  </li>
</ol>
