import React from "react";
import {Article} from "../services/models";
import Link from "next/link";
interface ArticleProps {
    article: Article
}
const Article: React.FC<ArticleProps> = ({article}) => (
    <div>
        <div className="alert alert-primary" role="alert">
            <h5>
                <Link target={"_blank"} className={'text-decoration-none'} href={article.url}>
                     {article.title}
                </Link>
            </h5>
        </div>
    </div>
)

export default Article;