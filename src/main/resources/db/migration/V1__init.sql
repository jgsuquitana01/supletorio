CREATE TABLE  IF NOT EXISTS curso(
    id SERIAL,
    descripcion VARCHAR(300) NOT NULL,
    aula VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
    );