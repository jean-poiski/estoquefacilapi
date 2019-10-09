package com.poiski.estoquefacilapi.repository.custom;

import com.poiski.estoquefacilapi.model.Despesa;

public interface DespesaRepositoryCutsom
{
    Despesa searchByStock(final Long idStock);
}
