CREATE VIEW estudiante_view as

SELECT e.*, c.aula curso
FROM estudiante e JOIN  curso c
ON e.curso_id = c.id;