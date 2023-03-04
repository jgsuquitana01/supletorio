CREATE TABLE  IF NOT EXISTS estudiante(
    id SERIAL,
    cedula VARCHAR(10) NOT NULL,
    fullname VARCHAR(20) NOT NULL,
    curso_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(curso_id) REFERENCES curso(id)
    );