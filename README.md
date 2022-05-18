# SIET - Sistema de Información de Enfermedades Tropicales
## Descripión
Software desarrollado en Java para el Laboratorio del CERETROP - Centro Regional de Enfermedades Tropicales.
## Componentes
- **Gestion de Recepciones**
  <br>Se realiza los procesos de registrar y modificar a un paciente con sus exámenes que estén solicitando, ingresar los resultados de los exámenes e iniciar seguimientos en caso de que sean necesarios y también se gestiona los establecimientos de la cuales fueron derivados.

- **Gestion de Perfil**
  <br>El usuario de la cuenta podrá realizar modificaciones de su información personal y tambien cambiar su contraseña en caso de que lo requiera.
  
- **Gestion de Pacientes**
  <br>Se obtiene una lista de todos los pacientes que acudieron al laboratorio, se puede obtener su historial clinico e identificar que pacientes estan bajo seguimiento.
  
- **Gestion de Personal Técnico**
  <br>Se obtiene una lista de todo el personal tecnico que esta activo en el laboratorio. Se puede agregar a nuevo personal técnico siempre y cuando este primeramente registrado, se puede dar de baja a un personal técnico que ya no este trabajando en el laboratorio y restablecer la contraseña de la cuenta de algún usuario que lo haya olvidado y lo solicite de manera personal al encargado del laboratorio.
  
- **Gestion de Reactivos**
  <br>En este componente se realiza el control de los reactivos que fueron entregados al laboratorio, que caducaron y los que se consumieron. El software ordena los reactivos de acuerdo a su fecha de vencimiento para que así el personal técnico pueda consumir los reactivos que estan mas proximos a su fecha de vencimiento. También muestra la cantidad de reactivos disponibles en almacen.
  
- **Gestion de Equipos**
  <br>En este componente se realiza el control de los equipos del laboratorio, tanto de los que estan activos, equipos en intervención y los que estan dados de baja. Tambien se puede obtener un historial de cada equipo para conocer por todas las intervenciones(mantenimientos, reparaciones, etc) por las que haya pasado el equipo hasta la fecha o durante toda su vida útil.
  
- **Gestion de Estudios**
  <br>En este componente se realiza el control de todos los exámenes que realiza el laboratorio, permitiendo y dando la facilidad que el o la encargado(a) del laboratorio pueda registrar nuevos exámenes que el laboratorio, en un futuro, pueda 
implementar. También se permite controlar las muestras biológicas que son permisibles en cada estudio.

- **Gestion de Informes**
  <br>En este componente se genera el Informe Mensual en formato PDF para que luego pueda ser cargado al SNIS.
