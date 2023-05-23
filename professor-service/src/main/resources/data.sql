--SUBJECTS:
    INSERT INTO subject (name)
    VALUES ('Estrutura de Dados'), ('Banco de Dados I'), ('Banco de Dados II'), ('Lógica de Prog. e Algoritmos'), 
    ('Arquitetura de Software'), ('Governança de TI'), ('Racicínio Lógico'), ('Compiladores'), ('Projeto Final');

--PROFESSORS
    --FERNANDO:
        INSERT INTO professor (name)
        VALUES ('Fernando Cézar Reis Borges');
        INSERT INTO professor_subject (professor_id, subject_id)
        VALUES (1, 1), (1, 2), (1, 3);

        --OSVALDO
        INSERT INTO professor (name)
        VALUES ('Osvaldo Requião Mello');
        INSERT INTO professor_subject (professor_id, subject_id)
        VALUES (2, 4), (2, 5), (2, 6);

        --HAMILTON
        INSERT INTO professor (name)
        VALUES ('Hamilton Batista Sobrinho');
        INSERT INTO professor_subject (professor_id, subject_id)
        VALUES (3, 7), (3, 8), (3, 9);

        --NEIVA
        INSERT INTO professor (name)
        VALUES ('Antônio Cláudio Pedreira Neiva');
        INSERT INTO professor_subject (professor_id, subject_id)
        VALUES (4, 1), (4, 4), (4, 9);