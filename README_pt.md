# Manipulação de Sprites em Java

Este projeto exibe um exemplo de controle de _sprites_ animados em Java.

## Introdução

Este projeto é baseado no artigo [**"Ultimate Java Image Manipulation"**](https://www.javalobby.org//articles/ultimate-image/) de Josiah Hester. Porém, há algumas diferenças entre a implementação aqui e a implementação original:

 - No código original, o _sprite_ é desenhado diretamente em um JFrame. Neste projeto, o sprite é desenhado em um JPanel, que está inserido dentro do JFrame;
 - O _sprite_ não se movimentava pela tela, apenas mudava a animação de movimento. Neste projeto, ele se move pela tela, utilizando o teclado;
 - O projeto atual foi dividido em um modelo MVC (_model-control-view_) para facilitar uma possível manutenção. 

## Licença de Uso

Os códigos disponibilizados aqui estão sob a GNU General Public License, versão 3.0 (veja o arquivo `LICENSE` em anexo para mais detalhes). Dúvidas sobre este projeto podem ser enviadas para o meu e-mail: carloswdecarvalho@outlook.com.