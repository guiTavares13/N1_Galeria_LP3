CREATE SCHEMA `tbsistema` ;
use tbSistema;

CREATE TABLE `tbsistema`.`tblider` (
  `LD_ID` INT NOT NULL,
  `LD_NOME` VARCHAR(245) NULL,
  PRIMARY KEY (`LD_ID`));
  
  
  CREATE TABLE `tbSistema`.`tbProjeto` (
  `PJT_ID` INT NOT NULL,
  `PJT_NOME` VARCHAR(245) NOT NULL,
  `PJT_DESCRICAO` VARCHAR(512) NULL,
  `PJT_CLIENTE` VARCHAR(245) NOT NULL,
  `PJT_HISTORIA` VARCHAR(512) NULL,
  `PJT_DATA_ENTREGA` DATETIME NOT NULL,
  `PJT_DESENVOLVEDORES` INT NOT NULL,
  `PJT_SM` INT NOT NULL,
  `PJT_REQUISITOS_FUNCIONAIS` INT NOT NULL,
  `PJT_REQUISITOS_SISTEMA` INT NOT NULL,
  `PJT_BLOQUEIO` VARCHAR(512) NULL,
  `PJT_SUJESTOES` VARCHAR(512) NULL,
  `PJT_CONCLUIDO` INT NULL,
  PRIMARY KEY (`PJT_ID`),
  UNIQUE INDEX `PJT_ID_UNIQUE` (`PJT_ID` ASC) VISIBLE);
  
  
  CREATE TABLE `tbsistema`.`tbdesenvolvedoreslista` (
  `DEVL_ID` INT NOT NULL,
  `RSL_DEV_ID` INT NOT NULL,
  `RFL_DEV_ID` INT NOT NULL,
  `PJTL_ID` INT NOT NULL,
  UNIQUE INDEX `DEVL_ID_UNIQUE` (`DEVL_ID` ASC) VISIBLE,
  UNIQUE INDEX `RSL_DEV_ID_UNIQUE` (`RSL_DEV_ID` ASC) VISIBLE,
  UNIQUE INDEX `RFL_DEV_ID_UNIQUE` (`RFL_DEV_ID` ASC) VISIBLE,
  UNIQUE INDEX `PJTL_ID_UNIQUE` (`PJTL_ID` ASC) VISIBLE,
  PRIMARY KEY (`DEVL_ID`));
  
  CREATE TABLE `tbsistema`.`tbdesenvolvedor` (
  `DEV_ID` INT NOT NULL,
  `DEV_NOME` VARCHAR(245) NULL,
  `DEV_PROJETOS` INT NULL,
  `DEV_FUNCOES` INT NOT NULL,
  PRIMARY KEY (`DEV_ID`));
  
  CREATE TABLE `tbsistema`.`tbrequisitosfuncionaislista` (
  `RFL_ID` INT NOT NULL,
  `RFL_PJT_ID` INT NOT NULL,
  `RFL_DEV_ID` INT NOT NULL,
  UNIQUE INDEX `RFL_ID_UNIQUE` (`RFL_ID` ASC) VISIBLE,
  UNIQUE INDEX `RFL_PJT_ID_UNIQUE` (`RFL_PJT_ID` ASC) VISIBLE);


CREATE TABLE `tbsistema`.`tbrequisitossistemalista` (
  `RSL_ID` INT NOT NULL,
  `RSL_PJT_ID` INT NOT NULL,
  `RSL_DEV_ID` INT NOT NULL,
  UNIQUE INDEX `RSL_ID_UNIQUE` (`RSL_ID` ASC) VISIBLE,
  UNIQUE INDEX `RSL_PJT_ID_UNIQUE` (`RSL_PJT_ID` ASC) VISIBLE);
  
  CREATE TABLE `tbsistema`.`tbrequisitofuncional` (
  `RF_ID` INT NOT NULL,
  `RF_TITULO` VARCHAR(245) NULL,
  `RF_DESCRICAO` VARCHAR(245) NULL,
  `RF_ITENS_REQUISITOS` INT NULL,
  `RF_HORAS` DATETIME NOT NULL,
  PRIMARY KEY (`RF_ID`),
  UNIQUE INDEX `RF_ITENS_REQUISITOS_UNIQUE` (`RF_ITENS_REQUISITOS` ASC) VISIBLE);

CREATE TABLE `tbsistema`.`tbrequisitosistema` (
  `RS_ID` INT NOT NULL,
  `RS_TITULO` VARCHAR(245) NULL,
  `RS_DESCRICAO` VARCHAR(512) NULL,
  `RS_ITENS_REQUISITOS` INT NOT NULL,
  PRIMARY KEY (`RS_ID`),
  UNIQUE INDEX `RS_ID_UNIQUE` (`RS_ID` ASC) VISIBLE,
  UNIQUE INDEX `RS_ITENS_REQUISITOS_UNIQUE` (`RS_ITENS_REQUISITOS` ASC) VISIBLE);


CREATE TABLE `tbsistema`.`tbitensrequisitofuncionallista` (
  `IRFL_ID` INT NOT NULL,
  `IRFL_RF_ID` INT NOT NULL,
  UNIQUE INDEX `IRFL_ID_UNIQUE` (`IRFL_ID` ASC) VISIBLE,
  UNIQUE INDEX `IRFL_RF_ID_UNIQUE` (`IRFL_RF_ID` ASC) VISIBLE);

CREATE TABLE `tbsistema`.`tbitemrequisitofuncional` (
  `IRF_ID` INT NOT NULL,
  `IR_TITULO` VARCHAR(245) NULL,
  `IR_CONCLUIDO` INT NULL,
  PRIMARY KEY (`IRF_ID`),
  UNIQUE INDEX `IRF_ID_UNIQUE` (`IRF_ID` ASC) VISIBLE);
  
  CREATE TABLE `tbsistema`.`tbitensrequisitosistemalista` (
  `IRSL_ID` INT NOT NULL,
  `IRSL_RS_ID` INT NOT NULL,
  UNIQUE INDEX `IRSL_ID_UNIQUE` (`IRSL_ID` ASC) VISIBLE,
  UNIQUE INDEX `IRSL_RS_ID_UNIQUE` (`IRSL_RS_ID` ASC) VISIBLE);
  
  CREATE TABLE `tbsistema`.`tbitemrequisitosistema` (
  `IRS_ID` INT NOT NULL,
  `RS_TITULO` VARCHAR(245) NULL,
  `RS_CONCLUIDO` INT NULL,
  PRIMARY KEY (`IRS_ID`),
  UNIQUE INDEX `IRS_ID_UNIQUE` (`IRS_ID` ASC) VISIBLE);


 alter table tbProjeto
 add constraint FK_PJT_SM foreign key (PJT_SM) references tbLider(LD_ID);

 alter table tbdesenvolvedoreslista
 add constraint FK_DEVL_ID foreign key (DEVL_ID) references tbDesenvolvedor(DEV_ID);

 alter table tbprojeto
 add constraint FK_PJT_DESENVOLVEDORES foreign key (PJT_DESENVOLVEDORES) references tbdesenvolvedoreslista(PJTL_ID);
 
  alter table tbrequisitofuncional
 add constraint FK_RF_ID foreign key (RF_ID) references tbrequisitosfuncionaislista(RFL_ID);
 
   alter table tbProjeto
 add constraint FK_PJT_REQUISITOS_FUNCIONAIS foreign key (PJT_REQUISITOS_FUNCIONAIS) references tbrequisitosfuncionaislista(RFL_PJT_ID);
 
 
 
   alter table tbrequisitosistema
 add constraint FK_RS_ID foreign key (RS_ID) references tbrequisitossistemalista(RSL_ID);
 
   alter table tbProjeto
 add constraint FK_PJT_REQUISITOS_SISTEMA foreign key (PJT_REQUISITOS_SISTEMA) references tbrequisitossistemalista(RSL_PJT_ID);
 
 
 
    alter table tbitemrequisitofuncional
 add constraint FK_IRF_ID foreign key (IRF_ID) references tbitensrequisitofuncionallista(IRFL_ID);
 
   alter table tbitensrequisitofuncionallista
 add constraint FK_IRFL_RF_ID foreign key (IRFL_RF_ID) references tbrequisitofuncional(RF_ITENS_REQUISITOS);
 
 
  
    alter table tbitemrequisitosistema
 add constraint FK_IRS_ID foreign key (IRS_ID) references tbitensrequisitosistemalista(IRSL_ID);
 
   alter table tbrequisitosistema
   add constraint FK_RS_ITENS_REQUISITOS foreign key (RS_ITENS_REQUISITOS) references tbitensrequisitosistemalista(IRSL_ID);


 alter table tbrequisitossistemalista
 add constraint FK_RSL_DEV_ID foreign key (RSL_DEV_ID) references tbdesenvolvedoreslista(RSL_DEV_ID);
 
    alter table tbrequisitosfuncionaislista
 add constraint FK_RFL_DEV_ID foreign key (RFL_DEV_ID) references tbdesenvolvedoreslista(RFL_DEV_ID);