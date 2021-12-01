@F_login
Feature: Loguearse en Benefit Interbank
  Rule: Yo como usuario, deseo ingresar a la aplicacion con mi cuenta

    @Automated
    @Happy_path
    @Functional_testing
    @LOGIN
    Scenario Outline: [HAPPY PATH]Validar el ingreso con diferentes tipo de documento - Usuario existente
      Given que el usuario esta en iframe de iniciar sesion de benefit
      And selecciona la opcion inicia sesion
      When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
      And el presiona el boton ingresar
      Then valida que el cliente tiene <millas> millas

      Examples: Ingresa con documento DNI
        | tipoDocumento | numDoc   | contrasena | millas      |
        | DNI           | 50501729 | Auto2021@  | 991,051,897 |

      Examples: Ingresa con documento CE
        | tipoDocumento        | numDoc   | contrasena | millas  |
        | Carné de extranjería | CE201701 | Abc12345$  | 0 |

      Examples: Ingresa con documento PASAPORTE
        | tipoDocumento | numDoc   | contrasena | millas  |
        | Pasaporte     | AD100004 | Abc12345$  | 990,987,590 |

    @Automated
    @Unhappy_path
    @Functional_testing
    @LOGIN
    Scenario Outline: [UNHAPPY PATH] Validar login con mensajes de error back
      Given que el usuario esta en iframe de iniciar sesion de benefit
      And selecciona la opcion inicia sesion
      When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
      And el presiona el boton ingresar
      Then el visualiza el error back <error>

      Examples: Ingresa con numero documento incorrecto
        | tipoDocumento | numDoc   | contrasena | error                                                                         |
        | DNI           | 79505017 | Auto2021@  | Aún no estás registrado en Interbank Benefit. Para ingresar, crea una cuenta. |

      Examples: Ingresa contraseña incorrecta
        | tipoDocumento | numDoc   | contrasena    | error                                                                 |
        | DNI           | 50501729 | Auto2021@2020 | Lo sentimos los datos ingresados son inválidos, inténtalo nuevamente. |

      Examples: Ingresa cliente con cuenta bloqueada
        | tipoDocumento | numDoc   | contrasena | error                                                                                                                                                                          |
        | DNI           | 50503449 | Abc12345$  | Debes tener una tarjeta activa del programa para continuar. Para mayor información, comunícate con nosotros a la Banca Telefónica al 311 9020 (Lima) o 080100802 (Provincias). |

      Examples: Ingresa cliente con cuenta cancelada
        | tipoDocumento | numDoc   | contrasena | error                                                                                                                                                                          |
        | DNI           | 50503452 | Abc12345$  | Debes tener una tarjeta activa del programa para continuar. Para mayor información, comunícate con nosotros a la Banca Telefónica al 311 9020 (Lima) o 080100802 (Provincias). |

    @Automated
    @regresion
    @cambioMensaje
    @complejidad:media
    @LOGIN
    Scenario Outline: [UNHAPPY ALTERNATIVE PATH] Validar el formulario login sin ingresar documento
      Given que el usuario esta en iframe de iniciar sesion de benefit
      And selecciona la opcion inicia sesion
      When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
      And el presiona el boton ingresar
      Then el muestra un mensaje debajo de documento <mensaje>
      Examples: No ingresar numero documento
        | tipoDocumento        | numDoc | contrasena | mensaje                     |
        | DNI                  |        | pass0101   | Debes ingresar un documento |
        | Carné de extranjería |        | abc12345   | Debes ingresar un documento |
        | Pasaporte            |        | abc12345   | Debes ingresar un documento |
    @Automated
      @regresion
      @cambioMensaje
      @complejidad:media
      @LOGIN
    Scenario Outline: [UNHAPPY ALTERNATIVE PATH] Validar el formulario login sin ingresar contraseña
      Given que el usuario esta en iframe de iniciar sesion de benefit
      And selecciona la opcion inicia sesion
      When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
      And el presiona el boton ingresar
      Then el muestra un mensaje debajo de contrasena <mensaje>

      Examples: No ingresar contrasena
        | tipoDocumento | numDoc   | contrasena | mensaje                               |
        | Pasaporte     | AD100001 |            | Ingresa una contraseña para continuar |

    @Automated
      @regresion
      @complejidad:alta
      @LOGIN
    Scenario Outline: [UNHAPPY PATH] Validar mensajes de error back
      Given que el usuario esta en iframe de iniciar sesion de benefit
      And selecciona la opcion inicia sesion
      When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
      And el presiona el boton ingresar
      Then el visualiza el error back <error>

      Examples: Numero documento incorrecto
        | tipoDocumento | numDoc   | contrasena | error                                                                   |
        | DNI           | 76503293 | abc12345   | Aún no estás registrado en Interbank Benefit. Para ingresar, crea una cuenta. |

      Examples: Contraseña Incorrecta
        | tipoDocumento | numDoc   | contrasena | error                                                                 |
        | DNI           | 50501528 | abc12345   | Lo sentimos los datos ingresados son inválidos, inténtalo nuevamente. |

      Examples: Contraseña Incorrecta mas de una vez
        | tipoDocumento | numDoc   | contrasena | error                                                                                                                          |
        | DNI           | 07423201 | abc12345   | Lo sentimos los datos ingresados son inválidos, inténtalo nuevamente. |

      Examples: Ingresar usuario con TD Bloqueado
        | tipoDocumento | numDoc   | contrasena | error                                                                                                                                                                          |
        | DNI           | 52460027 | abc123456  | Debes tener una tarjeta activa del programa para continuar. Para mayor información, comunícate con nosotros a la Banca Telefónica al 311 9020 (Lima) o 080100802 (Provincias). |

    @Automated
    @regresion
    @Unhappy_path
    @complejidad:baja
    @LOGIN
    Scenario: [UNHAPPY ALTERNATIVE PATH] Validar la funcionalidad del enlace Crear Cuenta
      Given que el usuario esta en iframe de iniciar sesion de benefit
      And selecciona la opcion inicia sesion
      When el selecciona el enlace Crear Cuenta
      Then visualiza la pagina de Crear Cuenta

    @manual
    @regresion
      @Unhappy_path
      @complejidad:baja
    Scenario Outline:[UNHAPPY ALTERNATIVE PATH] Validar la funcionalidad del enlace Retroceder
      Given que el usuario se encuentra en la url <url>
      And selecciona la opcion inicia sesion
#      And el ingresa a la pantalla de login
      When el selecciona el enlace retroceder
      Then el valida que se regresa a la url anterior <url>

      Examples: URL
        | url                                            |
        | https://saaspp.com/WebSaas/viajes              |
        | https://saaspp.com/WebSaas/categorias          |
        | https://saaspp.com/WebSaas/                    |
        | https://saaspp.com/WebSaas/tiendas             |
        | https://saaspp.com/WebSaas/es-tiempo-de-ayudar |

    @manual
    Scenario: Validar la funcionalidad de desbloqueo de usuario, desde el administrador
      Given Manual - el usuario estando en la pantalla de login
      And Manual - el ya excedio el número de intentos permitidos
      When Manual - el ingresa en otra pestaña al administrador y desbloqua al usuario
      And Manual - el retorna al portal benni y selecciona el botón Ingresar del login
      Then Manual - el se logea a Interbank Benefit
      And Manual - el muestra la cantidad de millas "<millas>" que posee

    @manual
    Scenario: Validar la funcionalidad del desbloqueo de usuario, pasando las 00:00 horas
      Given Manual - el usuario estando en la pantalla de login
      And Manual - el ya excedio el número de intentos permitidos
      When Manual - el ingresa al portal al siguiente día
      And Manual - el selecciona su tipo de documento y número de documento
      And Manual - el retorna al portal Interbank Benefit y selecciona el botón Ingresar del login
      Then Manual - el se logea a Interbank Benefit
      And Manual - el muestra la cantidad de millas que posee

    @manual
    Scenario: Validar la funcionalidad de quitar la suspension de usuario, desde el administrador
      Given Manual - el usuario estando en la pantalla de login
      And Manual - el con el mensaje generado: XXXXXXXXX
      When Manual - el ingresa en otra pestaña al administrador BIM y desbloquea al usuario
      And Manual - el retorna al portal Interbank Benefit y selecciona el botón Ingresar del login
      Then Manual - el se logea a Interbank Benefit
      And Manual - el muestra la cantidad de millas que posee



