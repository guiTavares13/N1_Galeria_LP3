import React from "react";
import './TagItem.css';

const TagItem = (props) => {
    if (props.formato == "imagem") {
        return (
            <div className="tagItem">
                <img className="tag-image" src={props.path} alt={props.nomeimagem} loading="lazy" />
                <div className="tag-nome">
                    <p>{props.tag}</p>
                </div>
            </div>
        );
    } else{
        return (
            <button className="btn-tag">
                {props.tag}
            </button>
        );
    }
};

export default TagItem;

/*

            <div className="tag-nome">
                <p>MĂșltiplas pessoas juntas</p>
            </div>

        <div className="tagItem">
            <img className="tag-image" src={props.path} alt={props.nomeimagem} loading="lazy" />

            <div className="tag-sombra">
                <p>MĂșltiplas</p>
            </div>
        </div>
*/