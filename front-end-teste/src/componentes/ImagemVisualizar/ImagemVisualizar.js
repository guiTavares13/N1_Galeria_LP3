import React from "react";
import './ImagemVisualizar.css';

const ImagemVisualizar = (props) => {
    return (
        <div className="imagem-visualizar">
            <img className="imagem-visualizar-img" src={props.path} alt={props.nomeimagem} loading="lazy" />
        </div>
    );
};

export default ImagemVisualizar;