@F_Micuenta
Feature: Informacion Mi Cuenta Cliente
  Rule: Como cliente deseo ver informacion de mi cuenta y gestionarlo


    Background: Login Benefit
      Given que el usuario esta en iframe de iniciar sesion de benefit
      And selecciona la opcion inicia sesion
      And el selecciona el tipo de documento DNI e ingresa numero de documento 90021131 y contrasena Interbank@2
      And el presiona el boton ingresar

    @Automated
      @regresion
      @complejidad:baja
#      @MI_CUENTA
    Scenario Outline: [HAPPY PATH] Validar la informacion de la cabecera
      And que el usuario ingresa a Mi Cuenta para verificar su información
      Then el muestra el primer nombre del cliente <primerNombre>
      And el muestra la cantidad de millas <millas>

      Examples: Cliente con 2 nombres
        | primerNombre     | millas    |
        | ¡Hola, Gloria!   | 0 |
#      Examples: Cliente con nombre largo
#        | primerNombre | millas |
#        |              |        |
#      Examples: Cliente con nombre corto
#        | primerNombre | millas |
#        |              |        |
#      Examples: Cliente con millas mas de 1000000
#        | primerNombre | millas |
#        |              |        |
#      Examples: Cliente con 0 millas
#        | primerNombre | millas |
#        |              |        |
#      Examples: Cliente con millas negativas
#        | primerNombre | millas |
#        |              |        |

    @Automated
    @regresion
    @complejidad:baja
#    @MI_CUENTA
    Scenario:[UNHAPPY ALTERNATIVE PATH] Validar la seleccion del logotipo "Interbank Benefit"
      And que el usuario ingresa a Mi Cuenta para verificar su información
      When el selecciona el logo de Interbank Benefit
      Then el valida que se redirecciona al Home de Benefit
#
    @Automated
      @regresion
      @complejidad:media
#      @MI_CUENTA
    Scenario Outline: [HAPPY PATH] Validar la seleccion de la opcion informacion personal
      And que el usuario ingresa a Mi Cuenta para verificar su información
      When el selecciona la opcion de informacion personal
      Then el muestra la pantalla de informacion personal
      And el identifica la ruta Cuenta > Informacion personal en la parte superior
      And el identifica su nombre completo del cliente
      And el muestra su numero de celular ofuscado <numero> y el enlace Actualizar
      And el muestra el correo electronico ofuscado <correo> y el enlace Actualizar
      And el muestra la casilla informativa correo <informacion>
      Examples: Pantalla Informacion Personal
        | numero    | correo                        | informacion                  |
        | Aún no tienes un celular registrado. | jul············@encora.com | ¿Cómo se usa mi información? |


    @regresion
    @Automated
    @complejidad:media
#    @MI_CUENTA
    Scenario:  [HAPPY PATH] Validar la seleccion de la opcion Inicio de Sesion y Seguridad
      And que el usuario ingresa a Mi Cuenta para verificar su información
      When el selecciona la opcion de Inicio de sesion y seguridad
      Then el muestra la pantalla de Inicio de sesion y seguridad
      And el identifica la ruta Cuenta > Inicio de sesion y seguridad
      And el identifica la informacion Última actualización: ayer y el enlace Actualizar
      And el muestra la casilla informativa sesion y seguridad Mantenemos la seguridad de tu cuenta

    @regresion
    @Automated
    @complejidad:media
#    @MI_CUENTA
    Scenario: [UNHAPPY ALTERNATIVE PATH] Validar la navegabilidad de la ruta informacion personal
      And que el usuario ingresa a Mi Cuenta para verificar su información
      When el selecciona la opcion de informacion personal
      And el selecciona en la ruta parte Cuenta
      Then el muestra la pantalla de Mi Cuenta

    @Automated
    @regresion
    @complejidad:media
    @MI_CUENTA
    Scenario: [Navegabilidad] Validar la funcionalidad Actualizar en Numero de celular
      And que el usuario ingresa a Mi Cuenta para verificar su información
      When el selecciona la opcion de informacion personal
      And el selecciona en enlace Actualizar de Numero de celular
      Then el valida que el enlace cambia de Actualizar a Cancelar
#      And el identifica el combobox Operador
#      And el identifica el campo Numero de celular
#      And el identifica el boton Guardar

    @sprint70
    @navegabilidad
    @complejidad:media
    Scenario: [Navegabilidad] Validar la funcionalidad de Ir a Banca por Internet
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de informacion personal
      And el selecciona en enlace Actualizar de Numero de celular
      And el visualiza el modal Actualiza tu celular en tu Banca Por Internet o cajero
      And el selecciona el enlace Ir a Banca por Internet
      Then le redirige a la Url https://bancaporinternet.interbank.pe/login#/login


    @sprint70
    @navegabilidad
    @complejidad:media
    Scenario: [Navegabilidad] Validar la funcionalidad de Buscar el cajero más cercano
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de informacion personal
      And el selecciona en enlace Actualizar de Numero de celular
      And el visualiza el modal Actualiza tu celular en tu Banca Por Internet o cajero
      And el selecciona el enlace Buscar el cajero más cercano
      Then le redirige a la Url https://interbank.pe/puntos-de-atencion


    @sprint70
    @navegabilidad
    @complejidad:media
    Scenario: [Navegabilidad] Validar la funcionalidad Cancelar en el modal Actualiza tu celular en tu Banca Por Internet o cajero
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de informacion personal
      And el selecciona en enlace Actualizar de Numero de celular
      Then el visualiza el modal Actualiza tu celular en tu Banca Por Internet o cajero
      And el selecciona el icono Cancelar
      Then el visualiza que el modal se cierra sin cambios

#      And el valida que las opciones de operador y numero de celular se ocultan

#    Scenario Outline: Validar las opciones de comboBox Operador
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <operador>
#      Then el muestra el <operador> seleccionado
#      Examples: Operador Bitel
#        | operador |
#        | Bitel    |
#      Examples: Operador Claro
#        | operador |
#        | Claro    |
#      Examples: Operador Entel
#        | operador |
#        | Entel    |
#      Examples: Operador Movistar
#        | operador |
#        | Movistar |
#
    #Scenario Outline: Validar el ingreso de numero de celular
    #  Given que el usuario ingresa a Mi Cuenta
    #  When el selecciona la opcion de informacion personal
    #  And el selecciona en enlace Actualizar de Numero de celular
    #  And el cambia su nuevo numero <celular> en el campo
    #  Then el muestra el nuevo numero de celular <celularMostrado>
    #  Examples: Validar Actualizacion
    #    | celular         | celularMostrado |
    #    | 123456789       | 123456789       |
       # | 123456789012345 | 123456789       |
      #  | abc123456       | 123456          |
      #  | 12345#$%&       | 12345           |


#    Scenario Outline: Validar los mensajes de error de actualizar el numero de celular
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el cambia su nuevo numero <numCel> en el campo
#      And el selecciona el boton Guardar
#      Then el muestra el mensaje de error de celular <num> del <mensaje>  debajo del campo

#    Examples: Numero de celular incorrecto
#      |numCel |num| mensaje                         |
#      | 969   | 1 | *Ingrese un N° de celular válido|

#    Examples: Numero de celular vacio
#      |numCel | num| mensaje                 |
#      |       | 2  |*Ingrese un N° de celular|


#  Scenario Outline: Validar la funcionaldiad del boton guardar del numero de celular
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <numOperador>
#      And el cambia su nuevo numero <celular> en el campo
#      And el selecciona el boton Guardar
#      Then el muestra el modal: Ingresa el código para guardar el cambio
#      And el identifica el correo electronico ofuscado <correo>
#      And el muestra el enlace Volver a enviar
#      And el muestra el boton Guardar nuevo numero
#      And el muestra el boton Cancelar

#      Examples: Boton Guardar del numero Celular
#                Movistar = 4
#        | numOperador | celular   | correo |
#        | 4           | 969929151 | xxxxx  |

#    @manual
#    Scenario: Validar el email con el codigo de confirmacion por actualizacion de numero de celular
#      Given Manual - que el usuario ingresa a Mi Cuenta
#      When Manual - el selecciona la opcion de informacion personal
#      And Manual - el selecciona en enlace Actualizar de Numero de celular
#      And Manual - el selecciona el comboBox Operador
#      And Manual - el selecciona el operador Movistar
#      And Manual - el cambia su nuevo numero 969929151 en el campo
#      And Manual - el selecciona el boton Guardar
#      Then Manual - el muestra el modal: Ingresa el código para guardar el cambio
#      And Manual - el verifica el email registrado en otro navegador
#      And Manual - el muestra en el asunto del correo: Confirmación de cambio de número de celular
#      And Manual - el muestra el primer nombre y primer apellido en el contenido
#      And Manual - el muestra el mensaje: ¡Has cambiado el número de celular que tenías asociado a Interbank Benefit!
#      And Manual - el muestra un código numérico de 06 dígitos

#    Scenario Outline: Validar el ingreso de codigo de confirmacion en el cambio de numero de celular
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <operador>
#      And el cambia su nuevo numero <celular> en el campo
#      And el selecciona el boton Guardar
#      And el ingresa el codigo <codigoCelular> en el campo
#      Then el muestra el codigo ingresado <codigoCelularMostrado>
#      Examples: Codigos de Confirmacion
#        | operador | celular   | codigoCelular   | codigoCelularMostrado |
#        | Bitel    | 123456789 | 123456          | 123456                |
#        | Bitel    | 123456789 | 123456789012345 | 123456                |
#        | Bitel    | 123456789 | abc123456       | 123456                |
#        | Bitel    | 123456789 | 12345#$%&       | 12345                 |
#
#    Scenario Outline: Validar los mensajes de error del codigo de confirmacion en el cambio de numero de celular
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <operador>
#      And el cambia su nuevo numero <celular> en el campo
#      And el selecciona el boton Guardar
#      And el ingresa el codigo <codigoCelular> en el campo
#      And el presiona el boton Guardar nuevo numero
#      Then el visualiza los mensajes de error <mensaje> debajo del campo de texto
#      Examples: Validacion ampo codigo confirmacion
#        | operador | celular   | codigoCelular | mensaje                  |
#        | Bitel    | 123456789 |               | Código obligatorio       |
#        | Bitel    | 123456789 | 123           | Ingrese un código válido |
#        | Bitel    | 123456789 | 111111        | Ingrese un código válido |
#
#    @manual
#    Scenario: Validar el mensaje de error por expiracion del codigo de confirmacion en el cambio de numero de celular
#      Given Manual - Estando en el modal: Ingresa el código para guardar el cambio
#      When Manual - ingreso el código obtenido del email
#      And Manual - dejo transcurrir sin ninguna acción más de 5 minutos
#      And Manual - selecciono el botón Guardar nuevo número
#      Then Manual - muestra en la cabecera el mensaje: Tu código de validación ha expirado, inténtalo nuevamente.
#
#    Scenario Outline: validar el reenvio de codigo de confirmacion en el cambio de numero de celular
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <operador>
#      And el cambia su nuevo numero <celular> en el campo
#      And el selecciona el boton Guardar
#      And el presiona el enlace Volver a enviar
#      Then el visualiza el mensaje de exito de reenvio <mensaje> en la parte superior
#      Examples: Reenvio de codigo
#        | operador | celular   | mensaje                                         |
#        | Bitel    | 123456789 | Listo, el código ha sido reenviado a tu correo. |
#
#    Scenario Outline: Validar la funcionalidad del boton Guardar nuevo numero, en el modal del cambio de numero de celular
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <operador>
#      And el cambia su nuevo numero <celular> en el campo
#      And el selecciona el boton Guardar
#      And el ingresa el codigo <codigoCelular> en el campo
#      And el presiona el boton Guardar nuevo numero
#      Then el valida que se cierra el modal y muestra la pantalla de informacion personal
#      And el muestra en la pantalla el numero ingresado ofuscado y seguido del operador seleccionado <numOp>
#      Examples: Verificar numero ofuscado y operador
#        | operador | celular   | codigoCelular | numOp |
#        | Bitel    | 123456789 | 123456        | xxx   |
#
#    Scenario Outline: Validar la funcionalidad del boton Cancelar, en el modal del cambio de numero celular
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <operador>
#      And el cambia su nuevo numero <celular> en el campo
#      And el selecciona el boton Guardar
#      And el ingresa el codigo <codigoCelular> en el campo
#      And el presiona el boton Cancelar
#      Then el valida que se cierra el modal y muestra la pantalla de informacion personal
#      Examples: Boton Cancelar
#        | operador | celular   | codigoCelular |
#        | Bitel    | 123456789 | 123456        |
#
#    Scenario Outline: Validar que el numero se actualizado correctamente
#      Given que el usuario ingresa a Mi Cuenta
#      When el selecciona la opcion de informacion personal
#      And el selecciona en enlace Actualizar de Numero de celular
#      And el selecciona el comboBox Operador
#      And el selecciona el operador <operador>
#      And el cambia su nuevo numero <celular> en el campo
#      And el selecciona el boton Guardar
#      And el ingresa el codigo <codigoCelular> en el campo
#      And el presiona el boton Guardar nuevo numero
#      Then el valida que se cierra el modal y muestra la pantalla de informacion personal
#      And el muestra en la cabecera el mensaje: Tu número de celular se ha actualizado.
#      Examples: Actualizacion del numero de celular
#        | operador | celular   | codigoCelular |
#        | Bitel    | 123456789 | 123456        |
#
#    @manual
#    Scenario: Validar el email de confirmación por actualización del número celular
#      Given Manual - Estando en modal: Ingresa el código para guardar el cambio
#      When Manual - ingreso el código obtenido en el correo registrado
#      And Manual - selecciono el botón Guardar nuevo número
#      Then Manual - se cierra el modal y muestra la pantalla Información personal
#      And Manual - verifico el email registrado en otro navegador
#      And Manual - muestra en el asunto del correo: Confirmación de cambio de número de celular
#      And Manual - muestra el primer nombre y primer apellido en el contenido
#      And Manual - muestra el mensaje exitoso: ¡Has asociado exitosamente un nuevo número de celular a Interbank Benefit!
#
    Scenario Outline: Validar la funcionalidad Actualizar en Correo Electronico
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de informacion personal
      And el selecciona en enlace Actualizar de Correo Electronico
      Then el visualiza el modal: Actualiza tu correo en la Banca por Internet
      And el identifica el correo registrado ofuscado <correoOfuscado>
      And el visualiza el boton Ir a Banca por Internet
      Examples: Modal Actualizacion Correo
        | correoOfuscado |
        | pru················@gmail.com |
#
    Scenario: Validar la funcionalidad del boton Ir a Banca por Internet
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de informacion personal
      And el selecciona en enlace Actualizar de Correo Electronico
      And el presiona el boton Ir a Banca por Internet
      Then el muestra la nueva pagina de https://bancaporinternet.interbank.pe/login#/login

    Scenario: Validar la funcionalidad del icono cerrar del modal Actualiza tu correo en tu Banca por Internet
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de informacion personal
      And el selecciona en enlace Actualizar de Correo Electronico
      And el presiona el icono cerrar
      Then el muestra la pantalla de informacion personal sin cambios

    Scenario: Validar la navegabilidad de la ruta Inicio de sesion y seguridad
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el identifica la ruta Cuenta > Inicio de sesion y seguridad
      And el presiona el enlace Cuenta
      Then el muestra la pantalla de Mi Cuenta

    Scenario: Validar la funcionalidad Actualizar el Inicio de sesion
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      Then el visualiza que el enlace cambia po Cancelar
      And el identifica el campo Nueva contrasena
      And el identifica el campo Repite contrasena

    @manual
    Scenario: Validar el ingreso de una Nueva contrasena
      Given Manual - que el usuario ingresa a Mi Cuenta
      When Manual - el selecciona la opcion de Inicio de sesion y seguridad
      And Manual - el muestra la pantalla de Inicio de sesion y seguridad
      And Manual - el selecciona el enlace Actualizar en Contrasena
      And Manual - el ingresa la contrasena <contrasena>
      Then Manual - el visualiza un tooltip con un resultado en color de los requerimientos de la contrasena

    Scenario Outline: Validar los mensajes de error en ingreso de contrasena
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el mensaje de error <mensaje> en el primer campo
      And el visualiza el otro mensaje de error <mensajeRepite> en el segundo campo
      Examples: Los dos campos vacios
        | contrasena | repeatContrasena | mensaje | mensajeRepite |
        |            |                  |         |               |
      Examples: repite contrasena vacio
        | contrasena | repeatContrasena | mensaje | mensajeRepite |
        |            |                  |         |               |
      Examples: nueva contrasena vacio
        | contrasena | repeatContrasena | mensaje | mensajeRepite |
        |            |                  |         |               |
      Examples: datos invalidos
        | contrasena | repeatContrasena | mensaje | mensajeRepite |
        |            |                  |         |               |

    Scenario Outline: Validar la funcionalidad del boton Guardar en Inicio de sesion y seguridad
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el modal Ingresa el código para guardar el cambio
      And el visualiza el correo electronico ofuscado <correo>
      And el visualiza el enlace Volver a enviar
      And el visualiza el boton Guardar nueva contrasena
      And el visualiza el boton Cancelar
      Examples: Validate Boton Guardar
        | contrasena | repeatContrasena | correo |
        |            |                  |        |

    @manual
    Scenario: Validar el email con el codigo de activacion por actualizacion de contrasena
      Given Manual - que el usuario ingresa a Mi Cuenta
      When Manual - el selecciona la opcion de Inicio de sesion y seguridad
      And Manual - el muestra la pantalla de Inicio de sesion y seguridad
      And Manual - el selecciona el enlace Actualizar en Contrasena
      And Manual - el ingresa la nueva contrasena
      And Manual - el ingresa la contrasena repetida
      And Manual - el presiona el boton Guardar
      Then Manual - el visualiza el modal Ingresa el código para guardar el cambio
      And Manual - el verifica el email registrado en otro navegador
      And Manual - el muestra en el asunto del correo: Confirmación de cambio de contraseña
      And Manual - el muestra el primer nombre y primer apellido en el contenido
      And Manual - el muestra el mensaje: ¿Quieres cambiar tu contraseña de Interbank Benefit?
      And Manual - el muestra un código numérico de 06 dígitos

    Scenario Outline: Validar el ingreso del codigo de confirmacion en Actualizar contrasena
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el modal Ingresa el código para guardar el cambio
      When el ingresa el codigo <codigo> en el campo
      Then el visualiza el codigo mostrado <codigoMostrado>
      Examples:
        | contrasena | repeatContrasena | codigo          | codigoMostrado |
        | Abc123456* | Abc123456*       | 123456          | 123456         |
        | Abc123456* | Abc123456*       | 123456789012345 | 123456         |
        | Abc123456* | Abc123456*       | abc123456       | 123456         |
        | Abc123456* | Abc123456*       | 12345#$%&       | 12345          |

    Scenario Outline: Validar los mensajes de error del codigo de confirmacion en Actualizar contrasena
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el modal Ingresa el código para guardar el cambio
      When el ingresa el codigo <codigo> en el campo
      And el presiona el boton Guardar nueva contrasena
      Then el visualiza el mensaje de error <error> debajo del campo
      Examples: Mensajes de Error
        | contrasena | repeatContrasena | codigo | error                    |
        | Abc123456* | Abc123456*       |        | Codigo Obligatorio       |
        | Abc123456* | Abc123456*       | 123    | Ingrese un código válido |
        | Abc123456* | Abc123456*       | 111111 | Ingrese un código válido |

    Scenario Outline: Validar el mensaje de error por expiracion del codigo de confirmacion en Actualizar contrasena
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el modal Ingresa el código para guardar el cambio
      When el ingresa el codigo <codigo> en el campo
      And el presiona el boton Guardar nueva contrasena
      Then el visualiza el mensaje de error backend <mensaje>
      Examples: Error Backend
        | contrasena | repeatContrasena | codigo | mensaje                     |
        | Abc123456* | Abc123456*       | 123456 | EL codigo esta expirado.... |

    Scenario Outline: Validar el reenvio del codigo de confirmacion en la actualizacion de contrasena
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el modal Ingresa el código para guardar el cambio
      When el selecciona el enlace de Volver a enviar
      Then el visualiza el mensaje <mensaje> en la parte superior
      Examples: Reenvio de codigo
        | contrasena | repeatContrasena | mensaje                                         |
        | Abc123456* | Abc123456*       | Listo, el código ha sido reenviado a tu correo. |

    Scenario Outline: Validar la funcionalidad del boton Guardar nueva contrasena en el modal de actualizar contrasena
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el modal Ingresa el código para guardar el cambio
      When el ingresa el codigo <codigo> en el campo
      And el presiona el boton Guardar nueva contrasena
      Then el visualiza en la cabecera el mensaje <mensaje>
      And el visualiza en la pantalla el texto <texto>
      Examples: Guardar Nueva contrasena
        | contrasena | repeatContrasena | codigo | mensaje                         | texto                     |
        | Abc123456* | Abc123456*       | 123456 | Tu contraseña se ha actualizado | Última actualización: hoy |

    Scenario Outline: Validar la funcionalidad del boton Cancelar en el modal de actualizacion de contrasena
      Given que el usuario ingresa a Mi Cuenta
      When el selecciona la opcion de Inicio de sesion y seguridad
      And el muestra la pantalla de Inicio de sesion y seguridad
      And el selecciona el enlace Actualizar en Contrasena
      And el ingresa la nueva contrasena <contrasena>
      And el ingresa la contrasena repetida <repeatContrasena>
      And el presiona el boton Guardar
      Then el visualiza el modal Ingresa el código para guardar el cambio
      When el ingresa el codigo <codigo> en el campo
      And el selecciona el boton Cancelar
      Then el visualiza que se cierra el moda y ve la pantalla de Inicio de swsion y seguridad
      Examples: Boton Cancelar
        | contrasena | repeatContrasena | codigo |
        | Abc123456* | Abc123456*       | 123456 |

    @manual
    Scenario: Validar el email de confirmacion por actualizacion de contrasena
      Given Manual - Estando en modal: Ingresa el código para guardar el cambio
      When Manual - ingreso el código obtenido en el correo registrado
      And Manual - selecciono el botón Guardar nueva contraseña
      Then Manual - se cierra el modal y muestra la pantalla Inicio de sesión y seguridad
      And Manual - verifico el email registrado en otro navegador
      And Manual - muestra en el asunto del correo: Confirmación de cambio de contraseña
      And Manual - muestra el primer nombre y primer apellido en el contenido
      And Manual - muestra el mensaje exitoso: ¡Has cambiado exitosamente tu contraseña para ingresar a Interbank Benefit.







