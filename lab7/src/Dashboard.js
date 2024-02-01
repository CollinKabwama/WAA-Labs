import { useState, useEffect } from 'react'
import Posts from './Posts'
import { data } from './data'
import axios from 'axios'

const url = 'http://localhost:8080/api/v1/posts'

const Dashboard = () => {
  const [content, setContent] = useState('')
  const [posts, setPosts] = useState(data)
  const [inputValue, setInputValue] = useState('')

  const [newPostTitle, setNewPostTitle] = useState('')
  const [newPostAuthor, setNewPostAuthor] = useState('')

  const [postId, setPostId] = useState(null)
  const [comments, setComments] = useState([])

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

  useEffect(() => {
    fetchData()
  }, [])

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

  const settingContent = (postId) => {
    setPostId(postId)
  }

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

  const handleNewPostTitleChange = (event) => {
    setNewPostTitle(event.target.value)
  }

  const handleNewPostAuthorChange = (event) => {
    setNewPostAuthor(event.target.value)
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
      <div className="content">{content}</div>

      <div>
        <form onSubmit={handleNewPostSubmit}>
          <div>
            <label>Title:</label>
            <input
              type="text"
              value={newPostTitle}
              onChange={handleNewPostTitleChange}
            />
          </div>
          <div>
            <label>Author:</label>
            <input
              type="text"
              value={newPostAuthor}
              onChange={handleNewPostAuthorChange}
            />
          </div>
          <button type="submit">Add Post</button>
        </form>
      </div>
    </div>
  )
}
export default Dashboard
