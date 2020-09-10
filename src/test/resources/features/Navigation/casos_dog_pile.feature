# language:es
Característica: Busqueda en Dogpile

  @virtual
  Escenario: Acceso a plataforma virtual desde chrome1
    Dado que el usuario entra en la pagina Dog
    Cuando el usuario inicia una busqueda de: rock argentino
    Entonces el usuario deberia ver resultados que contentan la palabra: rock

  Escenario: Acceso a plataforma virtual desde chrome2
    Dado que el usuario entra en la pagina Dog
    Cuando el usuario inicia una busqueda de: rock argentino
    Entonces el usuario deberia ver resultados que contentan la palabra: rock

  Esquema del escenario: Acceso a plataforma virtual desde chrome3
    Dado que el usuario entra en la pagina Dog
    Cuando el usuario inicia una busqueda de: <titulo>
    Entonces el usuario deberia ver resultados que contentan la palabra: <descripcion>

    Ejemplos:
      | titulo         | descripcion |
      | rock argentino | rock        |
      | rock argentino | rock        |