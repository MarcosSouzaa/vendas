"use client";

import { useEffect, useState } from "react";
import { Button } from "../components/ui/button";
import { getVeiculos, saveVeiculo } from "../services/veiculoService";

// 1. Interface Corrigida para eliminar o erro TS2353
interface Veiculo {
    id?: number;
    type?: string;
    marca: string;
    modelo: string;
    ano: number;
    preco: number;
}

export default function Home() {
    const [veiculos, setVeiculos] = useState<Veiculo[]>([]);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [novoVeiculo, setNovoVeiculo] = useState<Veiculo>({
        marca: "",
        modelo: "",
        preco: 0,
        ano: 2024
    });

    const carregarDados = () => {
        getVeiculos()
            .then(setVeiculos)
            .catch(err => console.error("Erro ao carregar:", err));
    };

    useEffect(() => {
        carregarDados();
    }, []);

    const handleSalvar = async () => {
        try {
            // Criamos o objeto explicitamente para o Java
            const veiculoDados: Veiculo = {
                type: "carro", // Deve ser igual ao nome no Java
                marca: novoVeiculo.marca,
                modelo: novoVeiculo.modelo,
                ano: Number(novoVeiculo.ano),
                preco: Number(novoVeiculo.preco)
            };

            await saveVeiculo(veiculoDados);

            setIsModalOpen(false);
            setNovoVeiculo({ marca: "", modelo: "", preco: 0, ano: 2024 });
            carregarDados();
            alert("Veículo cadastrado com sucesso!");
        } catch (error: unknown) {
            // Substituímos 'any' por 'unknown' e fazemos cast para evitar erro ESLint
            const err = error as any;
            console.error("Erro do Java:", err.response?.data);
            alert("Erro ao salvar! O Java (Porta 8080) parece estar desligado.");
        }
    };

    return (
        <div className="flex flex-col items-center justify-center min-h-screen p-8 gap-6 bg-slate-50 text-slate-900">
            <h1 className="text-4xl font-bold tracking-tight text-[#1e293b]">Sistema de Vendas 2026</h1>

            <div className="w-full max-w-2xl bg-white border border-slate-200 rounded-xl shadow-lg p-6">
                <h2 className="text-xl font-semibold mb-4 border-b pb-2 text-slate-700">Estoque Atual (PostgreSQL)</h2>
                <ul className="divide-y divide-slate-100">
                    {/* Tipagem correta no map para evitar erro de 'any' */}
                    {veiculos.map((v: Veiculo) => (
                        <li key={v.id || Math.random()} className="py-3 flex justify-between items-center font-medium">
                            <span>
                                <strong className="text-slate-900">{v.marca}</strong>
                                <span className="ml-2 text-slate-600">{v.modelo} ({v.ano})</span>
                            </span>
                            <span className="text-blue-600 font-bold text-lg">
                                R$ {Number(v.preco).toLocaleString('pt-BR', { minimumFractionDigits: 2 })}
                            </span>
                        </li>
                    ))}
                </ul>
            </div>

            <div className="flex gap-4">
                <Button onClick={carregarDados} className="bg-blue-600 hover:bg-blue-700 text-white px-6">
                    Atualizar Lista
                </Button>
                <Button onClick={() => setIsModalOpen(true)} className="bg-emerald-500 hover:bg-emerald-600 text-white px-6">
                    Novo Cadastro
                </Button>
            </div>

            {isModalOpen && (
                <div className="fixed inset-0 bg-black/60 backdrop-blur-sm flex items-center justify-center p-4 z-50">
                    <div className="bg-white p-8 rounded-2xl shadow-2xl w-full max-w-md flex flex-col gap-5 border border-slate-100">
                        <h2 className="text-2xl font-bold text-slate-800">Cadastrar Veículo</h2>

                        <div className="flex flex-col gap-4">
                            <input
                                placeholder="Marca (Ex: Volkswagen)"
                                className="border border-slate-300 p-3 rounded-lg outline-none focus:ring-2 focus:ring-blue-500"
                                onChange={e => setNovoVeiculo({...novoVeiculo, marca: e.target.value})}
                            />
                            <input
                                placeholder="Modelo (Ex: Nivus)"
                                className="border border-slate-300 p-3 rounded-lg outline-none focus:ring-2 focus:ring-blue-500"
                                onChange={e => setNovoVeiculo({...novoVeiculo, modelo: e.target.value})}
                            />
                            <input
                                type="number"
                                placeholder="Ano (Ex: 2024)"
                                className="border border-slate-300 p-3 rounded-lg outline-none focus:ring-2 focus:ring-blue-500"
                                onChange={e => setNovoVeiculo({...novoVeiculo, ano: Number(e.target.value)})}
                            />
                            <input
                                type="number"
                                placeholder="Preço (Ex: 116990)"
                                className="border border-slate-300 p-3 rounded-lg outline-none focus:ring-2 focus:ring-blue-500"
                                onChange={e => setNovoVeiculo({...novoVeiculo, preco: Number(e.target.value)})}
                            />
                        </div>

                        <div className="flex gap-3 justify-end mt-2">
                            <Button onClick={() => setIsModalOpen(false)} variant="ghost">Cancelar</Button>
                            <Button onClick={handleSalvar} className="bg-emerald-500 hover:bg-emerald-600 text-white px-8">Salvar no Banco</Button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}