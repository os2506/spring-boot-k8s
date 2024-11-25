import type {GetServerSideProps, NextPage} from 'next'
import {ArticlesResponse} from "../../services/models";
import {fetchArticles} from "../../services/api";
import Articles from "../../components/Articles";
import SearchForm from "../../components/SearchForm";

interface HomeProps {
    articles: ArticlesResponse
    query?: string
}
const Home: NextPage<HomeProps> = (props) => {
  return (
    <div>
        <SearchForm/>
        <Articles articles={props.articles} query={props.query}/>
    </div>
  )
}

export const getServerSideProps: GetServerSideProps = async (context) => {
    const {page = 1, query = "" } = context.query
    const articles = await fetchArticles(parseInt(String(page)), String(query))
    return {
        props: {
            articles,
            query
        }
    }
}

export default Home
