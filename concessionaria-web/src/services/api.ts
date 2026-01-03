import axios from 'axios';

export const api = axios.create({
    baseURL: 'http://localhost:8080/api', // Endereço do seu Spring Boot no IntelliJ
});