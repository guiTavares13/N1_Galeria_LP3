import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import TelaInicial from './telas/TelaInicial/TelaInicial';
import ImagemItem from './componentes/ImagemItem/ImagemItem';
import TagItem from './componentes/TagItem/TagItem';
import ListaDeImagens from './componentes/ListaDeImagens/ListaDeImagens';
import TelaImagemDetalhes from './telas/TelaImagemDetalhes/TelaImagemDetalhes';
import TelaCadastroEdicaoAutor from './telas/TelaCadastroEdicaoAutor/TelaCadastroEdicaoAutor';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
      <TelaCadastroEdicaoAutor />
  </React.StrictMode>
);
