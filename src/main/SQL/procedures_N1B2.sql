create PROCEDURE spInsert_tbDesenvolvedores(_DEV_ID  int,_DEV_NOME varchar(245))
BEGIN
	insert into tbdesenvolvedor (DEV_ID,DEV_NOME) values (_DEV_ID,_DEV_NOME);
END$$
DELIMITER ;
DELIMITER $$


create PROCEDURE spUpdate_tbdesenvolvedor(_DEV_ID int, _DEV_NOME varchar(245),_DEV_PROJETOS int,_DEV_FUNCOES int)
BEGIN
   
    if _DEV_PROJETOS and  _DEV_FUNCOES is not null then
		update tbdesenvolvedor set 
        DEV_NOME = _DEV_NOME,
		DEV_PROJETOS=_DEV_PROJETOS,
        DEV_FUNCOES=_DEV_FUNCOES
		where DEV_ID=_DEV_ID;
	else
		update tbdesenvolvedor set 
        DEV_NOME = _DEV_NOME,
        DEV_PROJETOS=_DEV_PROJETOS,
		DEV_FUNCOES=_DEV_FUNCOES
		where DEV_ID=_DEV_ID;
    end if;
END$$
DELIMITER ;
