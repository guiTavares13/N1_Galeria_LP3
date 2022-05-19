import React, { useState } from "react";
import './ListaDeImagens.css';

import ImagemItem from "../ImagemItem/ImagemItem";

const ListaDeImagens = (props) => {

    //const [imageCount, setImageCount] = useState(0);
    let pathImagem = "http://localhost:8080/backend_galeria/ImagemResposta?codigo=0"
    // Precisa chamar a API para que obtenha-se os paths e a exibição seja feita em cima disso

    return (
        <div className="listaImagens">
            <ImagemItem path={pathImagem} />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=5" />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=4" />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=6" />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=7" />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=8" />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=9" />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=10" />
            <ImagemItem path="http://localhost:8080/backend_galeria/ImagemResposta?codigo=11" />
        </div>
    );
};

export default ListaDeImagens;