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

INSERT INTO course (name) VALUES ('Matemática');
INSERT INTO course (name) VALUES ('Física');
INSERT INTO course (name) VALUES ('Ciência da Computação');
INSERT INTO course (name) VALUES ('Química');
INSERT INTO course (name) VALUES ('Biologia');

INSERT INTO subject (series, name, course_id) VALUES (1, 'Álgebra', 1);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Geometria', 1);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Mecânica', 2);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Eletricidade e Magnetismo', 2);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Programação', 3);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Estruturas de Dados', 3);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Química Orgânica', 4);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Química Inorgânica', 4);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Genética', 5);
INSERT INTO subject (series, name, course_id) VALUES (1, 'Microbiologia', 5);

INSERT INTO academic_year (year, start_date, end_date) VALUES (2021, '2021-02-01', '2021-12-20');
INSERT INTO academic_year (year, start_date, end_date) VALUES (2022, '2022-02-01', '2022-12-20');
INSERT INTO academic_year (year, start_date, end_date) VALUES (2023, '2023-02-01', '2023-12-20');

INSERT INTO federal_unit (acronym, name) VALUES ('PR', 'Paraná');
INSERT INTO federal_unit (acronym, name) VALUES ('SP', 'São Paulo');

INSERT INTO city (name, federal_unit_acronym) VALUES ('Cascavel', 'PR');
INSERT INTO city (name, federal_unit_acronym) VALUES ('Curitiba', 'PR');
INSERT INTO city (name, federal_unit_acronym) VALUES ('São Paulo', 'SP');
INSERT INTO city (name, federal_unit_acronym) VALUES ('Campinas', 'SP');
INSERT INTO city (name, federal_unit_acronym) VALUES ('Londrina', 'PR');
INSERT INTO city (name, federal_unit_acronym) VALUES ('Maringá', 'PR');
INSERT INTO city (name, federal_unit_acronym) VALUES ('Santos', 'SP');

INSERT INTO public_area_type (acronym, name) VALUES ('R', 'Rua');
INSERT INTO public_area_type (acronym, name) VALUES ('A', 'Avenida');
INSERT INTO public_area_type (acronym, name) VALUES ('P', 'Praça');

INSERT INTO public_area (name, public_area_type_acronym) VALUES ('Rua das Flores', 'R');
INSERT INTO public_area (name, public_area_type_acronym) VALUES ('Avenida Brasil', 'A');
INSERT INTO public_area (name, public_area_type_acronym) VALUES ('Praça da Sé', 'P');
INSERT INTO public_area (name, public_area_type_acronym) VALUES ('Rua XV de Novembro', 'R');
INSERT INTO public_area (name, public_area_type_acronym) VALUES ('Avenida Paraná', 'A');
INSERT INTO public_area (name, public_area_type_acronym) VALUES ('Praça Rui Barbosa', 'P');

INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES ('85819-000', 'Centro', 1, 1);
INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES ('80530-100', 'Batel', 2, 2);
INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES ('01001-000', 'Sé', 3, 3);
INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES ('13040-000', 'Cambuí', 1, 4);
INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES ('86010-000', 'Centro', 4, 5);
INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES ('87020-000', 'Zona 7', 5, 6);
INSERT INTO address (zip_code, neighborhood, public_area_id, city_id) VALUES ('11030-000', 'Ponta da Praia', 6, 7);

INSERT INTO professor (name, code, email, phone_number, address_id) VALUES ('Dr. João Oliveira', '123.456.789-01', 'joao.oliveira@example.com', '123456789', 1);
INSERT INTO professor (name, code, email, phone_number, address_id) VALUES ('Dra. Maria Santos', '987.654.321-02', 'maria.santos@example.com', '987654321', 2);
INSERT INTO professor (name, code, email, phone_number, address_id) VALUES ('Prof. Carlos Almeida', '192.837.465-03', 'carlos.almeida@example.com', '192837465', 3);
INSERT INTO professor (name, code, email, phone_number, address_id) VALUES ('Prof. Ana Lima', '564.738.291-04', 'ana.lima@example.com', '564738291', 4);

INSERT INTO student (name, code, email, phone_number, address_id) VALUES ('João Silva', '123.456.789-10', 'joao.silva@example.com', '123456789', 5);
INSERT INTO student (name, code, email, phone_number, address_id) VALUES ('Maria Souza', '987.654.321-20', 'maria.souza@example.com', '987654321', 6);
INSERT INTO student (name, code, email, phone_number, address_id) VALUES ('Carlos Pereira', '192.837.465-30', 'carlos.pereira@example.com', '192837465', 7);

INSERT INTO course_enrollment (date, student_id, course_id) VALUES ('2021-02-15', 1, 1);
INSERT INTO course_enrollment (date, student_id, course_id) VALUES ('2022-03-10', 2, 2);
INSERT INTO course_enrollment (date, student_id, course_id) VALUES ('2023-01-25', 3, 3);

INSERT INTO subject_class (academic_year_year, subject_id, professor_id) VALUES (2021, 1, 1);
INSERT INTO subject_class (academic_year_year, subject_id, professor_id) VALUES (2021, 2, 1);
INSERT INTO subject_class (academic_year_year, subject_id, professor_id) VALUES (2022, 3, 2);
INSERT INTO subject_class (academic_year_year, subject_id, professor_id) VALUES (2022, 4, 2);
INSERT INTO subject_class (academic_year_year, subject_id, professor_id) VALUES (2023, 5, 3);
INSERT INTO subject_class (academic_year_year, subject_id, professor_id) VALUES (2023, 6, 3);

INSERT INTO subject_class_enrollment (student_id, subject_class_id) VALUES (1, 1);
INSERT INTO subject_class_enrollment (student_id, subject_class_id) VALUES (1, 2);
INSERT INTO subject_class_enrollment (student_id, subject_class_id) VALUES (2, 3);
INSERT INTO subject_class_enrollment (student_id, subject_class_id) VALUES (2, 4);
INSERT INTO subject_class_enrollment (student_id, subject_class_id) VALUES (3, 5);
INSERT INTO subject_class_enrollment (student_id, subject_class_id) VALUES (3, 6);
