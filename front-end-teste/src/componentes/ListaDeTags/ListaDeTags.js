import React from "react";
import './ListaDeTags.css';
import TagItem from "../TagItem/TagItem";
import ListaDeApis from "../ListaDeAPIs/ListaDeApis";

const ListaDeTags = (props) => {
// Chamada de API
let formato = "imagem"

    return (
        <div className="lista-tags">
            <TagItem nomeimagem="jailson" path="http://localhost:8080/imagem?codigo=7"tag="Akkontece" formato={`${formato}`}/>
            <TagItem nomeimagem="jailson" path="http://localhost:8080/imagem?codigo=8"tag="Entregar a peça" formato={`${formato}`}/>
            <TagItem nomeimagem="jailson" path="http://localhost:8080/imagem?codigo=9"tag="Yamatopson" formato={`${formato}`}/>
            <TagItem nomeimagem="jailson" path="http://localhost:8080/imagem?codigo=10"tag="Português" formato={`${formato}`}/>
            <TagItem nomeimagem="jailson" path="http://localhost:8080/imagem?codigo=11"tag="Celso Portioli" formato={`${formato}`}/>
            <TagItem nomeimagem="jailson" path="http://localhost:8080/imagem?codigo=6"tag="Padoru Padoru" formato={`${formato}`}/>
            <TagItem nomeimagem="jailson" path="http://localhost:8080/imagem?codigo=5"tag="Azuren" formato={`${formato}`}/>

        </div>
    );
};

export default ListaDeTags;