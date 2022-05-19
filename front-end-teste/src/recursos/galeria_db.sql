CREATE DATABASE galeria_n2;
USE galeria_n2;

CREATE TABLE tb_autor (
    SK_autor_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    autor_nome VARCHAR(512) NOT NULL,
    autor_descricao VARCHAR(1024)
);

INSERT INTO tb_autor (autor_nome, autor_descricao) VALUES ('Autor Desconhecido', 'Autor desconhecido.');

CREATE TABLE tb_imagem (
    SK_imagem_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FK_autor_id INT NOT NULL,
    img_path VARCHAR(1024) NOT NULL,
    img_descricao VARCHAR(1024),
    data_envio DATETIME
);

CREATE TABLE tb_tag  (
    SK_tag_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    FK_tag_id INT,
    tag VARCHAR(128) NOT NULL
);

CREATE TABLE tb_imagemxtags (
    FK_imagem_id INT NOT NULL,
    FK_tag_id INT NOT NULL
);



-- STORED PROCEDURES
DELIMITER //

CREATE PROCEDURE sp_insert_tag(IN p_tag varchar(128))
BEGIN
    INSERT INTO tb_tag (tag) VALUES (p_tag);
END //

CREATE PROCEDURE sp_insert_subtag(IN p_tag varchar(128), IN p_tagpai_id int)
BEGIN
    INSERT INTO tb_tag (tag, FK_tag_id) VALUES (p_tagpai_id);
END //

CREATE PROCEDURE sp_insert_autor(IN p_autor_nome varchar(512), IN p_autor_descricao varchar(1024))
BEGIN
    INSERT INTO tb_autor (autor_nome, autor_descricao) VALUES (p_autor_nome, p_autor_descricao);
END //

CREATE PROCEDURE sp_insert_imagem(IN p_FK_autor_id int, IN p_img_path varchar(1024), IN p_img_descricao varchar(1024), IN p_data_envio datetime)
BEGIN
    INSERT INTO tb_imagem (FK_autor_id, img_path, img_descricao, data_envio) VALUES (p_FK_autor_id, p_img_path, p_img_descricao, p_data_envio);
END //

CREATE PROCEDURE sp_insert_imagemxtags(IN p_imagem_id int, IN p_tag_id int)
BEGIN
    INSERT INTO tb_imagemxtags (FK_imagem_id, FK_tag_id) VALUES (p_imagem_id, p_tag_id);
END //




CREATE PROCEDURE sp_delete_tag(IN p_tag_id int)
BEGIN
    DELETE FROM tb_tag WHERE SK_tag_id = p_tag_id;
END //

CREATE PROCEDURE sp_delete_autor(IN p_autor_id int)
BEGIN
    DELETE FROM tb_autor WHERE SK_autor_id = p_autor_id;
END //

CREATE PROCEDURE sp_delete_imagem(IN p_imagem_id int)
BEGIN
    DELETE FROM tb_imagem WHERE SK_imagem_id = p_imagem_id;
END //

CREATE PROCEDURE sp_delete_imagemxtags_imagem(IN p_imagem_id int)
BEGIN
    DELETE FROM tb_imagemxtags WHERE FK_imagem_id = p_imagem_id;
END //

CREATE PROCEDURE sp_delete_imagemxtags_tag(IN p_tag_id int)
BEGIN
    DELETE FROM tb_imagemxtags WHERE FK_tag_id = p_tag_id;
END //




CREATE PROCEDURE sp_select_tag(IN p_tag_id int)
BEGIN
    SELECT * FROM tb_tag WHERE SK_tag_id = p_tag_id;
END //

CREATE PROCEDURE sp_select_tags()
BEGIN
    SELECT * FROM tb_tag;
END //

CREATE PROCEDURE sp_select_autor(IN p_autor_id int)
BEGIN
    SELECT * FROM tb_autor WHERE SK_autor_id = p_autor_id;
END //

CREATE PROCEDURE sp_select_autores()
BEGIN
    SELECT * FROM tb_autor;
END //

CREATE PROCEDURE sp_select_imagem(IN p_imagem_id int)
BEGIN
    SELECT * FROM tb_imagem WHERE SK_imagem_id = p_imagem_id;
END //

CREATE PROCEDURE sp_select_imagens()
BEGIN
    SELECT * FROM tb_imagem;
END //

CREATE PROCEDURE sp_select_imagemxtags(IN p_imagem_id int)
BEGIN
    SELECT * FROM tb_imagemxtags WHERE FK_imagem_id = p_imagem_id;
END //




CREATE PROCEDURE sp_update_autor(IN p_autor_id int, p_autor_nome_novo varchar(512), IN p_autor_descricao_novo varchar(1024))
BEGIN
    UPDATE tb_autor SET autor_nome = p_autor_nome_novo, autor_descricao = p_autor_descricao_novo WHERE SK_autor_id = p_autor_id;
END //



DELIMITER ;