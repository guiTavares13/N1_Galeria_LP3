import React from "react";
import Navbar from "../../componentes/Navbar/navbar";
import { Outlet, Link } from "react-router-dom";

const TelaCadastroEdicaoAutor = () => {
    
    return (
        <div>
            <p>Teste cadastro de autor</p>
            <form method="post" action="http://localhost:8080/api/autor/cadastrar" enctype="multipart/form-data">
                <input type="text" name="nome" />
                <input type="text" name="descricao" />
                <input type="submit" value="Upload" />
            </form>
            
            <p>Teste edicao de autor</p>
            <form method="post" action="http://localhost:8080/api/autor/update" enctype="multipart/form-data">
                <input type="text" name="id" />
                <input type="text" name="nome" />
                <input type="text" name="descricao" />
                <input type="submit" value="Upload" />
            </form>
            
            <p>Teste exclusão de autor</p>
            <form method="post" action="http://localhost:8080/api/autor/delete" enctype="multipart/form-data">
                <input type="text" name="id" />
                <input type="submit" value="Upload" />
            </form>
        </div>
    );
};

export default TelaCadastroEdicaoAutor;