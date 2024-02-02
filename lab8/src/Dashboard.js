import { useState, useEffect, useContext, createContext } from 'react'
import Posts from './components/Posts'
import { data } from './data'
import axios from 'axios'
import NewPost from './components/NewPost'
import PostDetails from './components/PostDetails'

const url = 'http://localhost:8080/api/v1/posts'

export const DashboardContext = createContext()
// returns two components
// Provider - wrap return in Parent Component
// Consumer - replaced by useContext() hook

// custom hook

export const useDashboardContext = () => useContext(DashboardContext)

const Dashboard = () => {
  const [content, setContent] = useState('')
  const [posts, setPosts] = useState(data)
  const [inputValue, setInputValue] = useState('')

  const [newPostTitle, setNewPostTitle] = useState('')
  const [newPostAuthor, setNewPostAuthor] = useState('')

  const [postId, setPostId] = useState(null)
  const [comments, setComments] = useState([])

  //<PostDetails.Provider value = {{content}}> {PostDetails} </PostDetails.Provider>

  /////
  // Fetching all posts
  const fetchData = async () => {
    try {
      const response = await axios.get(url)
      setPosts(response.data)
    } catch (error) {
      console.error('Error fetching data:', error)
    }
  }

  /*useEffect(() => {
    fetchData()
  }, [])*/

  /////

  //////
  // Fetching individual post
  const fetchPostDetails = async () => {
    try {
      const response = await axios.get(`${url}/${postId}`)
      setContent(response.data)
    } catch (error) {
      console.error('Error fetching post details:', error)
    }
  }

  useEffect(() => {
    fetchPostDetails()
  }, [postId])

  /*const settingContent = (postId) => {
    setPostId(postId)
  }*/

  //////

  ////
  //Adding new Post

  const handleNewPostSubmit = async (event) => {
    event.preventDefault()
    const newPost = {
      title: newPostTitle,
      author: newPostAuthor,
    }

    try {
      const response = await axios.post(url, newPost)
      setPosts([...posts, response.data])
      setPosts([...posts, newPost])

      setNewPostTitle('')
      setNewPostAuthor('')
    } catch (error) {
      console.error('Error adding new post:', error)
    }
  }

  /////

  /////
  // Getting comments from a post
  const fetchComments = async () => {
    try {
      const response = await axios.get(`${url}/${postId}/comments`)
      setComments(response.data)
    } catch (error) {
      console.error('Error fetching comments:', error)
    }
  }

  useEffect(() => {
    fetchComments()
  }, [postId])

  /////

  const changeFirstTitle = () => {
    let newPosts = [...posts]

    newPosts[0] = { ...newPosts[0], title: inputValue }
    setInputValue('')

    setPosts(newPosts)
  }

  const handleInputChange = (event) => {
    setInputValue(event.target.value)
  }

  const settingContent = (values) => {
    setContent(values)
  }

  return (
    <div>
      <Posts posts={posts} settingContent={settingContent} />

      <input
        className="name"
        type="text"
        value={inputValue}
        name=""
        onChange={handleInputChange}
      />
      <button className="btn" onClick={changeFirstTitle}>
        Change Name
      </button>

      <DashboardContext.Provider value={{ content }}>
        <PostDetails />
      </DashboardContext.Provider>
      {/*<PostDetails content={content} />*/}

      <NewPost posts={posts} setPosts={setPosts} />
    </div>
  )
}
export default Dashboard
