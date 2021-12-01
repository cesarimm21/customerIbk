@F_CrearCuenta
Feature: Registro de nuevo usuario de Interbank Benefit
  Rule: Yo como PO deseo que el usuario deseo poder registrarme a la pagina de Interbank Benefit
  en caso sea un usuario nuevo

    @Automated @Happy_path @Functional_testing #@CREAR_CUENTA
    Scenario Outline: [HAPPY PATH] Crear cuenta con diferentes tipos de documentos
      Given que el usuario esta en iframe de iniciar sesion de benefit
      #PASO 1 DE 3
      And inicia el proceso de crear cuenta
      When ingresa sus datos :  <documentType>, <documentNumber>
      #PASO 2 DE 3
      And crea una contraseña : contraseña <contrasena> su confirmacion <recontrasena>, acepta uso de terminos y condiciones <terminos> y autotizo politicas de privacidad <politicas>
      #PASO 3 DE 3
      And revisa tu correo : ingresa el codigo otp 123456
      And selecciona la opcion crear cuenta
      Then se valida que el cliente tiene <millas> millas

      Examples: Crear cuenta con documento DNI
        | documentType | documentNumber | contrasena | recontrasena | terminos | politicas | millas |
        | DNI          | 27706000       | Abc12345$  | Abc12345$    | SI       | SI        | 0      |

      Examples: Crear cuenta con documento CE
        | documentType | documentNumber | contrasena | recontrasena | terminos | politicas | millas |
        | CE           | CE277062       | Abc12345$  | Abc12345$    | SI       | SI        | 0      |

      Examples: Crear cuenta con documento PASAPORTE
        | documentType | documentNumber | contrasena | recontrasena | terminos | politicas | millas |
        | PASS         | PS706000       | Abc12345$  | Abc12345$    | SI       | SI        | 0      |


	#@mobile
    @regresion
    @Automated
    @complejidad:media
      @CREAR_CUENTA
    Scenario: [Navegabiliad] Ingresar Paso 1
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      Then visualiza la pagina de registro
      When ingresa a Tienes una cuenta Inicia sesion
      Then visualiza la pagina de Login

	#@mobile
    @regresion
      @Automated
      @complejidad:media
      @CREAR_CUENTA
    Scenario Outline: [Happy Path] Continua Paso2
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  <tipo>, <numDoc>
      Then se visualiza la pagina de paso 2 Crea una contraseña

      Examples: Tipo Documento DNI
        | tipo | numDoc   |
        | DNI  | 90002147 |

#		Examples: Tipo Documento Carné de extranjeria
#			| tipo |numDoc	 |
#			| CE   |CE100002 |
#
#      Examples: Tipo Documento Pasaporte
#        | tipo | numDoc   |
#        | PASS | AD100007 |

	#@mobile
      @regresion
      @Automated
      @complejidad:media
      @CREAR_CUENTA
    Scenario Outline: [UNHAPPY PATH] Mensajes de Errores del formulario paso 1
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  <tipo>, <numDoc>
      Then se muestra el mensaje <msj_error> para el campo <campo> al empezar el registro

      Examples: Tipo documento no seleccionado
        | tipo       | numDoc   | msj_error             | campo |
        | Selecciona | 50501527 | Selecciona una opción | tipo  |

      Examples: Número de documento vacio
        | tipo | numDoc | msj_error                    | campo  |
        | DNI  |        | Debes ingresar un documento. | numDoc |

      Examples: Número de documento con letras o caracteres especiales
        | tipo | numDoc   | msj_error             | campo  |
        | DNI  | pruebaaa | Debe tener 8 dígitos. | tipo |


	#@mobile
    @regresion
      @Automated
      @complejidad:media
#      @CREAR_CUENTA
    Scenario Outline: [HAPPY PATH] Continuar paso 3
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  DNI, 50501527
      And  crea una contraseña : contraseña <contrasena> su confirmacion <recontrasena>, acepta uso de terminos y condiciones <terminos> y autotizo politicas de privacidad <politicas>
      Then se visualiza la pagina de paso 3 Revisa tu correo

      Examples:
        | contrasena | recontrasena | terminos | politicas |
        | Int3rba@nk | Int3rba@nk   | SI       | SI        |

	#@mobile
    @regresion
      @Automated
      @complejidad:media
#      @CREAR_CUENTA
    Scenario Outline:  [UNHAPPY PATH] Mensaje de error Paso 2
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  DNI, 90002134
      And  crea una contraseña : contraseña <contrasena> su confirmacion <recontrasena>, acepta uso de terminos y condiciones <terminos> y autotizo politicas de privacidad <politicas>
      Then se muestra el siguiente mensaje <msj_error> en el <campo> al continuar el paso 3

      Examples:
        | contrasena | recontrasena | terminos | politicas | msj_error                              | campo      |
        |            | Int3rba@nk   | SI       | SI        | Ingresa una contraseña para continuar. | contrasena |

      Examples:
        | contrasena | recontrasena | terminos | politicas | msj_error                        | campo        |
        | Int3rba@nk | Interbank    | SI       | SI        | Las contraseñas deben coincidir. | recontrasena |

	#@mobile
    @regresion
    @Automated
    @complejidad:media
#      @CREAR_CUENTA
    Scenario: [[HAPPY PATH]] Paso 2 - Ver terminos y condiciones
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  DNI, 90002135
      And  ingresa a terminos y condiciones
      Then se visualiza la ventana de Términos y condiciones del programa
      When selecciona entendido
      Then se visualiza la pagina de paso 2 Crea una contraseña
      When ingresa a Politicas de seguridad
      Then se visualizala ventana de Politicas de seguridad
      When selecciona entendido
      Then se visualiza la pagina de paso 2 Crea una contraseña
      When retroce a la pagina anterior
      Then visualiza la pagina de registro

	#Desestimado - Interactua con la pagina de correo
    @desestimado
      @complejidad:media
    Scenario Outline: [Validación] Mensaje de error Paso 3 : Código
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  DNI, 90002136
      And  crea una contraseña : contraseña Int3rba@nk su confirmacion Int3rba@nk, acepta uso de terminos y condiciones SI y autotizo politicas de privacidad SI
#      And  en Revisa tu correo : ingresa el codigo <cod>
      Then se muestra el mensaje de error <msj_mensaje>

      Examples: codigo menos a 6 dígitos
        | cod  | msj_mensaje                       |
        | 1234 | El código debe contener 6 dígitos |

      Examples: codigo vacio
        | cod | msj_mensaje        |
        |     | Código obligatorio |

      Examples: codigo no permite caracteres
        | cod    | msj_mensaje                       |
        | aaaaaa | El código debe contener 6 dígitos |


	#Desestimado - Interactua con la pagina de correo
    @desestimado
      @complejidad:media
    Scenario Outline: [Validación] Mensaje de error Paso 3 : Código - Back
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  DNI, 50501527
      And  crea una contraseña : contraseña Int3rba@nk su confirmacion Int3rba@nk, acepta uso de terminos y condiciones SI y autotizo politicas de privacidad SI
#      And  en Revisa tu correo : ingresa el codigo <codigo>
      Then se muestra mensaje de error back <msj_error>

      Examples: codigo vacio
        | codigo | msj_error                                                         |
        | 123456 | El código ingresado es incorrecto. Por favor, intenta nuevamente. |

      Examples: codigo expirado
        | codigo | msj_error                                                           |
        | 123456 | El código ha expirado. Genera un nuevo código e intenta nuevamente. |

    #Desestimado
    @complejidad:media
    Scenario:  [Navegabilidad] Paso 3
      Given que el usuario esta en iframe de iniciar sesion de benefit
      When inicia el proceso de crear cuenta
      And ingresa sus datos :  DNI, 50501527
      And  crea una contraseña : contraseña Int3rba@nk su confirmacion Int3rba@nk, acepta uso de terminos y condiciones SI y autotizo politicas de privacidad SI
#      When selecciona el enlace ¿Haz cambiado de correo?
      Then se visualiza ventana con información cambio de correo por Banca Telefonica
      When cierra la ventana de información
      Then se visualiza la pagina de paso 3 Revisa tu correo
      When selecciona el enlace volver a enviar
      Then se visualiza mensaje de confirmacion Hemos reenviado el código.
      When selecciono el enlace Retroceder
      Then se visualiza la pagina de paso 2 Crea una contraseña

