--BOOKING:
    INSERT INTO booking (approved, lab_id, professor_id, subject_id, time_init, time_final, time_request)
	VALUES (true, 1, 1, 1, '2023-10-22T10:00:00', '2023-10-22T12:00:00', CURRENT_TIMESTAMP);