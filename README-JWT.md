
# Autentificacion


Para acceder a los distintos métodos del Juego de dados descrito en el README tendremos que tener la autentificacion por JWT incluyendo en cada petición el campo Authorization en el Header.







##  ALta Usuario sin autentificacion . Acceso prohibido   403.


Todas las peticiones están protegidas   y  nos dará el error.





![image](https://github.com/eliseoBcn/S05T2N01EscobarJuliaAndres/assets/125320599/b60ac9bd-0ed7-421d-aa39-e1cdf6cdb8ec)



 

## Petición token . /user . Usuario administrador

Accedemos al la url /user e informados en el apartado de "Params" :


  1) user

  2) password


En la respuesta vemos el token generado para poder acceder al resto de las peticiones.








![image](https://github.com/eliseoBcn/S05T2N01EscobarJuliaAndres/assets/125320599/e4f565af-c5e1-4dce-acd3-5e3471acf7ae)





## Alta Usuario . Campo Authorization


En todos las peticiones informaremos el campo  Authorization .

Alta usuario  conseguida.

El resto de las peticiones funcionan exactamente igual informando dicho campo.




![image](https://github.com/eliseoBcn/S05T2N01EscobarJuliaAndres/assets/125320599/e8c3b2c0-0128-4e26-978b-6852711e219f)

 







