<!DOCTYPE html>
<html lang="tr">
<body>

<h1>🚀 Spring Boot JWT Authentication API with Swagger</h1>

<p>
Bu proje, <strong>Spring Boot</strong>, <strong>JWT tabanlı kimlik doğrulama</strong> ve
<strong>Swagger (OpenAPI 3)</strong> kullanılarak geliştirilmiş bir REST API örneğidir.
Amaç, güvenli bir backend mimarisi kurarken aynı zamanda
<strong>Swagger üzerinden kolayca test edilebilir</strong> bir API sunmaktır.
</p>

<hr>

<h2>🧱 Kullanılan Teknolojiler</h2>
<ul>
    <li>Java 17+</li>
    <li>Spring Boot</li>
    <li>Spring Security</li>
    <li>JWT (JSON Web Token)</li>
    <li>Swagger (Springdoc OpenAPI 3)</li>
    <li>Maven</li>
</ul>

<hr>

<h2>🔐 Güvenlik Mimarisi (JWT)</h2>
<p>Bu projede <strong>stateless</strong> bir güvenlik yapısı kullanılmaktadır.</p>

<h3>Temel Özellikler</h3>
<ul>
    <li>Session kullanılmaz (STATELESS)</li>
    <li>JWT token ile yetkilendirme</li>
    <li>Custom AuthenticationProvider</li>
    <li>Request bazlı JWT Filter</li>
    <li>Merkezi hata yönetimi (AuthEntryPoint)</li>
</ul>

<hr>

<h2>🔓 Public (Herkese Açık) Endpoint’ler</h2>
<p>Aşağıdaki endpoint’ler yetkilendirme gerektirmez:</p>

<pre>
POST /register
POST /authenticate
POST /refreshToken
</pre>

<hr>

<h2>📘 Swagger (OpenAPI) Entegrasyonu</h2>
<p>
Swagger entegrasyonu sayesinde API dokümantasyonu otomatik olarak oluşturulmuştur.
</p>

<h3>Swagger Erişim Adresleri</h3>
<pre>
/swagger-ui/index.html
/swagger-ui.html
/v3/api-docs
</pre>

<p>
Bu endpoint’ler Spring Security tarafından whitelist’e alınmıştır.
</p>

<hr>

<h2>🛡 Swagger Üzerinden JWT Kullanımı</h2>
<p>
Swagger arayüzünde <strong>Authorize</strong> butonu üzerinden JWT token girilerek
korumalı endpoint’ler test edilebilir.
</p>

<h3>Kullanım Formatı</h3>
<pre>
Bearer &lt;JWT_TOKEN&gt;
</pre>

<hr>

<h2>⚙️ Swagger Güvenlik Konfigürasyonu</h2>
<ul>
    <li>HTTP Bearer Authentication</li>
    <li>JWT formatı</li>
    <li>Global Security Requirement</li>
</ul>

<p>
Bu sayede Swagger UI tüm secured endpoint’lerde token zorunluluğunu otomatik olarak algılar.
</p>

<hr>

<h2>🔧 Spring Security Yapılandırması</h2>

<h3>Öne Çıkan Ayarlar</h3>
<ul>
    <li>CSRF devre dışı</li>
    <li>Stateless session yönetimi</li>
    <li>JWT Filter, UsernamePasswordAuthenticationFilter öncesinde çalışır</li>
    <li>Swagger path’leri security dışında tutulur</li>
</ul>

<pre>
/swagger-ui/**
/v3/api-docs/**
/swagger-ui.html
</pre>

<hr>

<h2>🧪 Test Akışı (Önerilen)</h2>
<ol>
    <li>/register → kullanıcı oluştur</li>
    <li>/authenticate → JWT token al</li>
    <li>Swagger UI → Authorize → token gir</li>
    <li>Korumalı endpoint’leri test et</li>
</ol>

<hr>

<h2>📂 Proje Yapısı (Özet)</h2>
<pre>
config/
 ├── SecurityConfig
 ├── SwaggerConfig
jwt/
 ├── JwtAuthenticationFilter
 ├── AuthEntryPoint
</pre>

<hr>

<h2>🎯 Projenin Amacı</h2>
<p>
Bu proje;
</p>
<ul>
    <li>JWT mantığını doğru şekilde uygulamak</li>
    <li>Swagger + Spring Security entegrasyonunu göstermek</li>
    <li>Kurumsal backend mimarilerine uygun bir örnek sunmak</li>
</ul>

<hr>

<h2>👨‍💻 Geliştirici</h2>
<p>
<strong>Oğuzhan Akduman</strong><br>
</p>

<hr>
