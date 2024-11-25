import axios from "axios"
import {ArticlesResponse} from "./models";
import getConfig from 'next/config'
const { serverRuntimeConfig, publicRuntimeConfig } = getConfig()

const getApiUrl = () => {
    return serverRuntimeConfig.API_BASE_URL || publicRuntimeConfig.API_BASE_URL;
}

export const fetchArticles = async (page: number, query: string): Promise<ArticlesResponse> => {


    console.log("serverRuntimeConfig :" , serverRuntimeConfig);
    console.log("publicRuntimeConfig :" , publicRuntimeConfig);


    let url = `${getApiUrl()}/api/articles?page=${page}`
    if(query) {
        url += `&query=${query}`
    }
    const res = await axios.get<ArticlesResponse>(url)
    return res.data
}

export const saveArticle = async (article:{title: string, url: string}) => {
    const res = await axios.post(`${getApiUrl()}/api/articles`, article)
    return res.data
}