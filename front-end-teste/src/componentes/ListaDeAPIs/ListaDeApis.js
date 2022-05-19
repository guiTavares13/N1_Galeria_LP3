const ListaDeApis = (props) => {
    switch (props.requisicao)
    {
        case "GET_IMAGEM":
            return JSON.stringify(`http://localhost:8080/imagem?codigo=${props.codigo}`);
            break;
        case "GET_AUTOR":
            return "";
            break;
    }
};

function teste()
{
    return "http://localhost:8080/imagem?codigo=7";
}

export default ListaDeApis