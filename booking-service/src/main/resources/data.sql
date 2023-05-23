--LAB:
    INSERT INTO lab (lami, description, status, desktops, location) 
    VALUES ('LAMI 1', 'Laboratório de Micro Informática 1', true, 20, 'B413');

--SUBJECT:
    INSERT INTO subject (name)
        VALUES ('Estrutura de Dados'), ('Segurança da Informação');

--PROFESSOR:
    --SEMÍRAMES:
        INSERT INTO professor (name)
        VALUES ('Semírames Ribeiro de Assis');
        INSERT INTO professor_subject (professor_id, subject_id)
        VALUES (1, 2);
    
    --GUERRA:
    INSERT INTO professor (name)
        VALUES ('Fernando Trioschi Fernandes Guerra');
        INSERT INTO professor_subject (professor_id, subject_id)
        VALUES (2, 1);

--BOOKING:
    INSERT INTO booking (approved, lab_id, professor_id, subject_id, time_init, time_final, time_request)
	VALUES (true, 1, 1, 1, '2023-10-22T10:00:00', '2023-10-22T12:00:00', CURRENT_TIMESTAMP);


