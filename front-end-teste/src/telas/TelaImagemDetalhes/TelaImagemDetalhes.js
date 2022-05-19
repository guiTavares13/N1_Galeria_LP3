import React from "react";

import ImagemVisualizar from "../../componentes/ImagemVisualizar/ImagemVisualizar";
import ListaDeTags from "../../componentes/ListaDeTags/ListaDeTags";

const TelaImagemDetalhes = () => {
    return (
        <div>
            <ImagemVisualizar path="http://localhost:8080/imagem?codigo=11" nomeimagem="Imagem de teste" />

            <form method="post" action="http://localhost:8080/imagem" enctype="multipart/form-data">
                <input type="text" name="descricao" />
                <input type="file" name="file" />
                <input type="submit" value="Upload" />
            </form>

            <ListaDeTags />

            <div className="tag-list">
            </div>
        </div>
    );



};

export default TelaImagemDetalhes;