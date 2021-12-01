@mail-otp

Feature: Mail con el código otp
  Rule: Yo como PO deseo una plantilla para el envio de codigo otp en el flujo de canje


    @regresion
    @web
    @mobile
    @pasarela-productos
    @complejidad:alta
    @manual
    @manual-result:passed
    @manual-last-tested:S3-Q1
    @manual-test-evidence:[PRO-PAGO-CP00X]assets/PRO-PAGO-CP00X.html
    Scenario: [Pasarela productos] Validar el mail OTP en productos
      Given Manual - el selecciona productos al carrito
      When  Manual - selecciona una dirección de entrega
      And Manual - selecciona un tipo de entrega
      And Manual - selecciona una cantidad de millas del canje
      Then Manual - visualiza la pantalla de pago
      And Manual - revisa el correo registrado y observa el mail Código de verificación para completar tu compra en Interbank Benefit
      When  Manual - el selecciona el enlace Volver a enviar código
      Then Manual - visualiza la imagen Cógigo enviado
      And Manual - revisa el correo registrado y observa otro mail Código de verificación para completar tu compra en Interbank Benefit


    @regresion
    @web
    @mobile
    @pasarela-vuelos
    @complejidad:alta
    @manual
    @manual-result:passed
    @manual-last-tested:S3-Q1
    @manual-test-evidence:[VUE-PAGO-CP00X]assets/VUE-PAGO-CP00X.html
    Scenario: [Pasarela vuelos] Validar el mail OTP en vuelos
      Given Manual - el usuario busca un vuelo
      When  Manual - el selecciona un vuelo del resultado
      And Manual - ingresa los datos del pasajero
      And Manual - ingresa los datos del contacto
      And Manual - ingreso el correo donde enviar el pasaje
      And Manual - selecciona las millas que usara
      Then Manual - visualiza la pantalla de pago
      And Manual - revisa el correo registrado y observa el mail Código de verificación para completar tu compra en Interbank Benefit
      When  Manual - el selecciona el enlace Volver a enviar código
      Then Manual - visualiza la imagen Cógigo enviado
      And Manual - revisa el correo registrado y observa otro mail Código de verificación para completar tu compra en Interbank Benefit


    @regresion
    @web
    @mobile
    @pasarela-vales
    @complejidad:alta
    @manual
    @manual-result:passed
    @manual-last-tested:S3-Q1
    @manual-test-evidence:[VAL-PAGO-CP00X]assets/VAL-PAGO-CP00X.html
    Scenario: [Pasarela vales] Validar el mail OTP en vales
      Given Manual - el usuario ingresa al mundo de Vales de consumo
      When  Manual - el selecciona un tipo de vale
      And  Manual - selecciona una dirección de entrega
      And Manual - selecciona un tipo de entrega
      And Manual - selecciona una cantidad de millas del canje
      Then Manual - visualiza la pantalla de pago
      And Manual - revisa el correo registrado y observa el mail Código de verificación para completar tu compra en Interbank Benefit
      When  Manual - el selecciona el enlace Volver a enviar código
      Then Manual - visualiza la imagen Cógigo enviado
      And Manual - revisa el correo registrado y observa otro mail Código de verificación para completar tu compra en Interbank Benefit


