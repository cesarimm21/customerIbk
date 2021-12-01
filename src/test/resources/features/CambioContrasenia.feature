@CambioContrasenia
Feature: Proyecto Benefit Home Mi Perfil - Cambio contraseña

	@Automated
	@Happy_path
	@CHANGE_PASSWORD1
	Scenario Outline: [HAPPY PATH] Cambio de contraseña en Mi cuenta
	Given que el usuario esta en iframe de iniciar sesion de benefit
	And selecciona la opcion inicia sesion
	When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
	And el presiona el boton ingresar
	And verificamos que estemos en la pagina de inicio con login
	And que el usuario ingresa a Mi Cuenta para verificar su información
	And el selecciona la opcion de Inicio de sesion y seguridad
	And verificamos la pagina de Inicio de sesión y seguridad
	And selecionamos la opcion de actualizar
	And ingresamos la nueva contraseña <newcontrasena>
	And verificamos el mensaje para ingresar el código e ingresamos el código <codigo>
	Then el valida el mensaje <mensaje> de confirmación de cambio contraseña

	Examples: Ingresa con documento DNI
	| tipoDocumento | numDoc   | contrasena |newcontrasena|codigo	|mensaje|
	| DNI           | 90021131 | Interbank$1 |     Interbank@2       |123456|Tu contraseña se ha reestablecido con éxito.|

	Examples: Ingresa con documento CE
	| tipoDocumento        | numDoc   | contrasena |newcontrasena| codigo  |mensaje|
	| Carné de extranjería | CE201701 | Abc12345$  |     Abc12345@       | 123456 |Tu contraseña se ha reestablecido con éxito.|

	Examples: Ingresa con documento PASAPORTE
	| tipoDocumento | numDoc   | contrasena |newcontrasena| codigo  |mensaje|
	| Pasaporte     | AD100004 | Abc12345$  |   Abc12345@          | 123456 |Tu contraseña se ha reestablecido con éxito.|

	@Automated
	@Happy_path
	@CHANGE_PASSWORD2
	Scenario Outline: [HAPPY PATH] Cambio de contraseña en Olvide mi contraseña
		Given que el usuario esta en iframe de iniciar sesion de benefit
		And selecciona la opcion inicia sesion
		When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
		And selecciona la opcion de Olvidaste tu contraseña
		When selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc>
		And seleccionamos la opcion continuar
		And ingresamos la nueva contraseña <newcontrasena>
		And el verifica el mensaje para revisa tu correo e ingresamos el código <codigo>
		Then el valida el mensaje <mensaje> de confirmación de cambio contraseña

		Examples: Ingresa con documento DNI
			| tipoDocumento | numDoc   |contrasena| newcontrasena|codigo	|mensaje|
			| DNI           | 90021131 |    Interbank@2      |  Interbank$1 |123456  |Tu contraseña se ha reestablecido con éxito.|

		Examples: Ingresa con documento CE
			| tipoDocumento        | numDoc   | contrasena |newcontrasena| codigo  |mensaje|
			| Carné de extranjería | CE201701 | Abc12345@  |    Abc12345$        | 123456 |Tu contraseña se ha reestablecido con éxito.|

		Examples: Ingresa con documento PASAPORTE
			| tipoDocumento | numDoc   | contrasena |newcontrasena| codigo  |mensaje|
			| Pasaporte     | AD100004 | Abc12345@   |    Abc12345$        | 123456 |Tu contraseña se ha reestablecido con éxito.|
	@Automated
	@Happy_path
	@CHANGE_PASSWORD
	Scenario Outline: [HAPPY PATH] Cambio de contraseña en Mi cuenta - Cambiar por la misma contraseña
		Given que el usuario esta en iframe de iniciar sesion de benefit
		And selecciona la opcion inicia sesion
		When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
		And el presiona el boton ingresar
		And verificamos que estemos en la pagina de inicio con login
		And que el usuario ingresa a Mi Cuenta para verificar su información
		And el selecciona la opcion de Inicio de sesion y seguridad
		And verificamos la pagina de Inicio de sesión y seguridad
		And selecionamos la opcion de actualizar
		And ingresamos la nueva contraseña <newcontrasena>
		And verificamos el mensaje para ingresar el código e ingresamos el código <codigo>
		Then el valida el mensaje <mensaje> de confirmación de cambio contraseña

		Examples: Ingresa con documento DNI
			| tipoDocumento | numDoc   | contrasena |newcontrasena|codigo	|mensaje|
			| DNI           | 90021131 | Interbank$1 |     Interbank$1       |123456|Tu contraseña se ha actualizado. |

	@Automated
	@Happy_path
	@CHANGE_PASSWORD
	Scenario Outline: [HAPPY PATH] Cambio de contraseña en Olvide mi contraseña - Cambiar por la misma contraseña
		Given que el usuario esta en iframe de iniciar sesion de benefit
		And selecciona la opcion inicia sesion
		When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
		And selecciona la opcion de Olvidaste tu contraseña
		When selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc>
		And seleccionamos la opcion continuar
		And ingresamos la nueva contraseña <newcontrasena>
		And el verifica el mensaje para revisa tu correo e ingresamos el código <codigo>
		Then el valida el mensaje <mensaje> de confirmación de cambio contraseña

		Examples: Ingresa con documento DNI
			| tipoDocumento | numDoc   |contrasena| newcontrasena|codigo	|mensaje|
			| DNI           | 90021131 |    Interbank$1      |  Interbank$1 |123456  |Tu contraseña se ha reestablecido con éxito. |

	@Automated
	@Unhappy_path
	@CHANGE_PASSWORD
	Scenario Outline: [UNHAPPY PATH] Cambio de contraseña en Mi cuenta - Contraseña no correcta
		Given que el usuario esta en iframe de iniciar sesion de benefit
		And selecciona la opcion inicia sesion
		When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
		And el presiona el boton ingresar
		And verificamos que estemos en la pagina de inicio con login
		And que el usuario ingresa a Mi Cuenta para verificar su información
		And el selecciona la opcion de Inicio de sesion y seguridad
		And verificamos la pagina de Inicio de sesión y seguridad
		And selecionamos la opcion de actualizar
		And ingresamos la nueva contraseña <newcontrasena>
		Then validamos el mensaje de <mensaje>

		Examples: Ingresa con documento DNI
			| tipoDocumento | numDoc   | contrasena |newcontrasena|mensaje	|
			| DNI           | 90021131 | Interbank$1 |     123456       | La contraseña debe cumplir con los requisitos. |

	@Automated
	@Unhappy_path
	@CHANGE_PASSWORD
	Scenario Outline: [UNHAPPY PATH] Cambio de contraseña en Olvide mi contraseña - Contraseña no correcta
		Given que el usuario esta en iframe de iniciar sesion de benefit
		And selecciona la opcion inicia sesion
		When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
		And selecciona la opcion de Olvidaste tu contraseña
		When selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc>
		And seleccionamos la opcion continuar
		And ingresamos la nueva contraseña <newcontrasena>
		Then validamos el mensaje de <mensaje>

		Examples: Ingresa con documento DNI
			| tipoDocumento | numDoc   |contrasena| newcontrasena|mensaje	|
			| DNI           | 90021131 |    Interbank$1      |  123456 |La contraseña debe cumplir con los requisitos.  |

	@Automated
	@Unhappy_path
	@CHANGE_PASSWORD
	Scenario Outline: [UNHAPPY PATH] Cambio de contraseña en Mi cuenta - Sin enviar valor campo nueva contraseña
		Given que el usuario esta en iframe de iniciar sesion de benefit
		And selecciona la opcion inicia sesion
		When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
		And el presiona el boton ingresar
		And verificamos que estemos en la pagina de inicio con login
		And que el usuario ingresa a Mi Cuenta para verificar su información
		And el selecciona la opcion de Inicio de sesion y seguridad
		And verificamos la pagina de Inicio de sesión y seguridad
		And selecionamos la opcion de actualizar
		And ingresamos la nueva contraseña <newcontrasena>
		Then validamos los mensajes de error <mensaje> de nueva contraseña y mensaje <repitamensaje> de repita contraseña

		Examples: Ingresa con documento DNI
			| tipoDocumento | numDoc   | contrasena |newcontrasena|mensaje	|repitamensaje|
			| DNI           | 90021131 | Interbank$1 |             |  Ingresa una contraseña para continuar.  | Las contraseñas deben coincidir. |

	@Automated
	@Unhappy_path
	@CHANGE_PASSWORD
	Scenario Outline: [UNHAPPY PATH] Cambio de contraseña en Olvide mi contraseña - Sin enviar valor campo nueva contraseña
		Given que el usuario esta en iframe de iniciar sesion de benefit
		And selecciona la opcion inicia sesion
		When el selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc> y contrasena <contrasena>
		And selecciona la opcion de Olvidaste tu contraseña
		When selecciona el tipo de documento <tipoDocumento> e ingresa numero de documento <numDoc>
		And seleccionamos la opcion continuar
		And ingresamos la nueva contraseña <newcontrasena>
		Then validamos los mensajes de error <mensaje> de nueva contraseña y mensaje <repitamensaje> de repita contraseña

		Examples: Ingresa con documento DNI
			| tipoDocumento | numDoc   |contrasena| newcontrasena|mensaje	|repitamensaje|
			| DNI           | 90021131 |    Interbank$1      |    | Ingresa una contraseña para continuar.  |Las contraseñas deben coincidir.|