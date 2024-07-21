SET foreign_key_checks = 0;

TRUNCATE TABLE subject_class_enrollment;
TRUNCATE TABLE subject_class;
TRUNCATE TABLE course_enrollment;
TRUNCATE TABLE student;
TRUNCATE TABLE professor;
TRUNCATE TABLE address;
TRUNCATE TABLE public_area;
TRUNCATE TABLE city;
TRUNCATE TABLE subject;
TRUNCATE TABLE course;
TRUNCATE TABLE academic_year;
TRUNCATE TABLE federal_unit;
TRUNCATE TABLE public_area_type;

SET foreign_key_checks = 1;


INSERT INTO federal_unit (acronym, name) VALUES ('PR', 'Paraná'), ('SP', 'São Paulo'), ('RJ', 'Rio de Janeiro');

INSERT INTO city (name, federal_unit_acronym) VALUES
('Cascavel', 'PR'),
('Curitiba', 'PR'),
('São Paulo', 'SP'),
('Rio de Janeiro', 'RJ');

INSERT INTO public_area_type (acronym, name) VALUES
('AV', 'Avenida'),
('R', 'Rua'),
('TR', 'Travessa');

INSERT INTO public_area (name, public_area_type_acronym) VALUES
('Avenida Brasil', 'AV'),
('Rua Paraná', 'R'),
('Travessa dos Lagos', 'TR'),
('Avenida Paulista', 'AV');

INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES
('85800-000', 'Centro', 1, 1),
('85801-000', 'Parque São Paulo', 2, 1),
('80000-000', 'Batel', 3, 2),
('01000-000', 'Bela Vista', 4, 3),
('20000-000', 'Copacabana', 1, 4);

INSERT INTO academic_year (year, end_date, start_date) VALUES
(2024, '2024-02-01', '2024-12-20'),
(2025, '2025-02-01', '2025-12-20'),
(2023, '2023-02-01', '2023-12-20');

INSERT INTO course (name) VALUES
('Ciência da Computação'),
('Engenharia Civil'),
('Direito');

INSERT INTO subject (name, series, course_id) VALUES
('Programação Orientada a Objetos', 1, 1),
('Estruturas de Dados', 1, 1),
('Cálculo I', 1, 2),
('Direito Constitucional', 1, 3),
('Linguagem formal', 1, 1),
('Computacao 1', 1, 1),
('Computacao 2', 1, 1);

INSERT INTO professor (name, code, email, address_id) VALUES
('João Silva', '111.111.111-11', 'joao.silva@example.com', 1),
('Ana Souza', '222.222.222-22', 'ana.souza@example.com', 2),
('Carlos Pereira', '333.333.333-33', 'carlos.pereira@example.com', 3),
('Maria Oliveira', '444.444.444-44', 'maria.oliveira@example.com', 4);

INSERT INTO subject_class (academic_year_year, name, subject_id, professor_id) VALUES
(2024, 'Pratica', 1, 1),  -- Programação Orientada a Objetos (Ciência da Computação)
(2024, 'Teorica', 2, 1),  -- Estruturas de Dados (Ciência da Computação)
(2025, 'Teorica', 3, 2),  -- Cálculo I (Engenharia Civil)
(2025, 'Teorica', 4, 3),  -- Direito Constitucional (Direito)
(2024, 'Teorica', 5, 1),  -- Linguagem Formal (Ciencia da computação)
(2023, 'Teorica', 6, 1),  -- Computacao 1 (Ciencia da computacao)
(2024, 'Teorica', 7, 1),  -- Computacao 2 (Ciencia da computacao)
(2024, 'Pratica', 7, 1);  -- Computacao 2 (Ciencia da computação)

INSERT INTO student (name, code, phone_number, email, address_id) VALUES
('Maria Souza', '555.555.555-55', '9999-9999', 'maria.souza@example.com', 2),
('Pedro Costa', '666.666.666-66', '8888-8888', 'pedro.costa@example.com', 3),
('Julia Martins', '777.777.777-77', '7777-7777', 'julia.martins@example.com',4),
('Lucas Almeida', '888.888.888-88', '6666-6666', 'lucas.almeida@example.com', 5),
('Gabriel Obregon', '333.333.333-33', '3333-3333', 'gabriel.obregon@example.com', 1);

INSERT INTO course_enrollment (number, date, student_id, course_id) VALUES
(1, '2024-02-10', 1, 1),  -- Maria Souza / Ciência da Computação
(2, '2024-02-15', 2, 2),  -- Pedro Costa / Engenharia Civil
(3, '2025-03-01', 3, 3),  -- Julia Martins / Direito
(4, '2025-03-05', 4, 1),  -- Lucas Almeida / Ciência da Computação
(5, '2024-04-09', 5, 1);  -- Gabriel Obregon / Ciência da computação

UPDATE student SET course_enrollment_id = 1 WHERE id = 1;
UPDATE student SET course_enrollment_id = 2 WHERE id = 2;
UPDATE student SET course_enrollment_id = 3 WHERE id = 3;
UPDATE student SET course_enrollment_id = 4 WHERE id = 4;
UPDATE student SET course_enrollment_id = 5 WHERE id = 5;

INSERT INTO subject_class_enrollment (number, subject_class_id, student_id) VALUES
(1, 1, 1),  -- Maria Souza / Programação Orientada a Objetos
(2, 2, 1),  -- Maria Souza / Estruturas de Dados
(3, 3, 2),  -- Pedro Costa / Cálculo I
(4, 4, 3);  -- Julia Martins / Direito Constitucional
