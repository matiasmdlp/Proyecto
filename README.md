# Proyecto

## integrantes
 Matias Leonardo Medina De La Peña (N° Matricula 2021409637)                                                                                                          
 Joaquin Sebastian Avalos Panes (Nº Matricula 2021413898)


# Tema 3: Animación de la física de lanzamiento de misiles desde un avión.

 En el panel central habrá un escenraio compuesto por avión, blanco y misil, en una animacion. El misil debe ir ajustando la ruta al blanco mediante las clases Angular
 y RellenarConpuntos. Deberá ser posible elegir la direccion de vuelo, la altura y velocidad del avion mediante controles GUI. El misil lanzado debera impactar sobre un
 blanco que se mueve a velocidad constante, pero elegida randomicamente, sobre la tierra en una de las dos direcciones. El contro de disparo se debe realizar mediante
 el mouse o con treclado o con controles GUI. El misil tendrá una distancia máxima de detección del blanco y dentro de una zona que forma aproximada a un arco, si no
 detecta, sigue en la dirección que venía. El misil ajusta su dirección al blanco en la medida que se mueve. El blanco, por defecto se mueve a la misma altura
 randómicamente elegida. Se podría cambiar la dirección del blanco mediante flechas del teclado. 
 
## cosas que no sabemos como hacer

- [X] Rotar una imagen una cantidad X de grados. (Logrado)
- [X] Realizar la deteccion del objeto y el seguimiento.  (Logrado)
- [X] Personalizacion del proyecto.  (Logrado)

## Patrones Utilizados

Durante el desarrollo del proyecto, se dio la necesidad de realizar acciones que afectaran a cada elemento por separado (avión u objetivo). Conociendo el prototipo del interfaz realizado en uno de los primeros pasos del proyecto, se decidió optar por el uso de un Patrón Proxy, así es posible realizar la elección del objeto a modificar y que solo se modifiquen las características de un solo objeto.
Patrón Proxy:  Permite modificar la altura, dirección de inicio, velocidad, tanto del avión y el misil o en su defecto la dirección de inicio y velocidad inicial del objetivo. Una vez iniciada la animación es posible solo modificar la dirección en la cual se mueve el objetivo.

## Casos de Uso
 ![Casos de uso](https://user-images.githubusercontent.com/56138987/203075962-a63e4299-6a54-448e-a240-829b33c2217e.png)
 
## Intefaz
![Interfaz](https://user-images.githubusercontent.com/56138987/204390488-ffe379d0-159e-45ce-9f0d-80c6484c6ee2.png)

## Decisiones

Se desarrollaron distintos prototipos para el proyecto final, con distintos métodos de detección y seguimiento de objetivo. En un principio se desarrollo el seguimiento directo del objetivo y el misil solo cambiaba de dirección hacia la posición del objetivo, esto no representaban lo pedido en el proyecto a desarrollar, por lo cual fue necesario el desarrollo de otro método de detección y seguimiento de objetivo, de esta forma fueron modificadas las cualidades de los objetos con los cuales se trabajan para lograr la detección y posteriores cálculos a realizar para el seguimiento y a la vez la rotación que debe generarse a la imagen del misil, así el movimiento logrado no solo se ve como un cambio de dirección, si no, se visualiza un movimiento de rotación, con un cambio paulatino de velocidad del misil en dirección al objetivo.

## Autocritica
 Durante el desarrollo del proyecto, se encontraron bastantes problemas con respecto a la presentación en pantalla de cada objeto y su interacción entre ellos, a la vez, una de las características que más difíciles de solventar, fue la detección del objetivo y posterior seguimiento,  para el cual el ayudante a cargo nos proporcionó una idea de detección y seguimiento, la cual fue utilizada en el proyecto, modificando parámetros para que de esta forma fuese factible la integración con el proyecto desarrollado hasta el momento. 
	Otro problema encontrado durante el desarrollo ha sido el trabajo con GIT, se han pasado algunas dificultades al momento de trabajar con esta herramienta, por el simple hecho de no conocer ciertas características del mismo, todo problema fue consultado con los ayudantes respectivos, quienes nos proporcionaron posibles soluciones, las cuales nos permitieron seguir avanzando el desarrollo del proyecto. 
	El uso y aplicación de JavaDoc y Test Junit, al ser la primera vez aplicando estos recursos, una de las dificultades encontradas, fue mantener actualizados los Javadoc, debido a las grandes modificaciones realizadas durante el desarrollo del proyecto. El desconocimiento de la correcta utilización de los test junit, fue una dificultad de cara a plantear un test que representase algo concreto dentro del proyecto. 
