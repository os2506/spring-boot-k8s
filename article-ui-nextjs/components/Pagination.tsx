import React from "react";
import Link from 'next/link'
import {ArticlesResponse} from "../services/models";

interface PaginationProps {
    articles: ArticlesResponse
    query?: string
}

const Pagination: React.FC<PaginationProps> = ({articles, query}) => {
    const path = "/articles";
    const queryParams = (query === undefined || query === "")? {}: {query: query}
    const firstPage = {pathname: path, query: { page: 1 , ...queryParams}}
    const previousPage = {pathname: path, query: { page: articles.currentPage - 1 , ...queryParams}}
    const nextPage = {pathname: path, query: { page: articles.currentPage + 1 , ...queryParams}}
    const lastPage = {pathname: path, query: { page: articles.totalPages , ...queryParams}}
    return(
        <div>
            <nav aria-label="Page navigation">
                <ul className="pagination justify-content-center">

                    <li className={"page-item " + (articles.hasPrevious ? "" : "disabled")}>
                        <Link className="page-link" href={firstPage}>
                            First
                        </Link>
                    </li>

                    <li className={"page-item " + (articles.hasPrevious ? "" : "disabled")}>
                        <Link className="page-link" href={previousPage}>
                            Previous
                        </Link>
                    </li>

                    <li className={"page-item " + (articles.hasNext ? "" : "disabled")}>
                        <Link className="page-link" href={nextPage}>
                            Next
                        </Link>
                    </li>

                    <li className={"page-item " + (articles.hasNext ? "" : "disabled")}>
                        <Link className="page-link" href={lastPage}>
                            Last
                        </Link>
                    </li>

                </ul>
            </nav>

        </div>
    );
}

export default Pagination;
