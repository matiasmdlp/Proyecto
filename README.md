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

- [ ] Rotar una imagen una cantidad X de grados. 
- [X] Realizar la deteccion del objeto y el seguimiento 
- [X] Personalizacion del proyecto

## Patrones Utilizados

Hemos decidido utilizar un Patron Proxy, Para la implementación de los botones de control.
Si bien, el objetivo debe tener una velocidad y dirección aleatoria, hemos puesto también la opción de controlar su dirección y velocidad de forma manual, mediante los mismo controles GUI que controlan la posición, dirección y velocidad del avión y misil. También es posible controlar la dirección del objetivo durante la animación.

## Casos de Uso
 ![Casos de uso](https://user-images.githubusercontent.com/56138987/203075962-a63e4299-6a54-448e-a240-829b33c2217e.png)
 
## Intefaz
![Interfaz](https://user-images.githubusercontent.com/56138987/204390488-ffe379d0-159e-45ce-9f0d-80c6484c6ee2.png)

