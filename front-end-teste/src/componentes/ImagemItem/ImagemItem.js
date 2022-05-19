import React from "react";
import './ImagemItem.css';

const ImagemItem = (props) => {
    return (
        <div className="imagemItem">
            <img className="item-image" src={props.path} alt={props.nomeimagem} loading="lazy" />
        </div>
    );
};

export default ImagemItem;