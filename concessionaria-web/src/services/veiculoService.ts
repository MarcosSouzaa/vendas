import {api} from "./api";

export const getVeiculos = async () => {
    const response = await api.get('/veiculos'); // Rota do seu Controller Java
    return response.data;
};

// Nova função para salvar no PostgreSQL via Java
export const saveVeiculo = async (veiculo:
                                  { marca: string; modelo: string; preco: number; ano: number }) => {
    const response = await api.post('/veiculos', veiculo);
    return response.data;
};