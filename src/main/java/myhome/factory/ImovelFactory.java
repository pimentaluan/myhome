package myhome.factory;

import myhome.domain.Imovel;

public interface ImovelFactory {
    String tipo();
    Imovel criar(ImovelSpec spec);
}
