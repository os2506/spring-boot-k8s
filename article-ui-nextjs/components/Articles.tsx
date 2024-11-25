import React from "react";
import {ArticlesResponse} from "../services/models";
import Article from "./Article";
import Pagination from "./Pagination";

interface ArticlesProps {
    articles: ArticlesResponse
    query?: string
}
const Articles: React.FC<ArticlesProps> = ({articles, query})=> (
    <div>
        <Pagination articles={articles} query={query}/>
        {articles.data.map(article => <Article key={article.id} article={article}/>)}
    </div>
);

export default Articles;