import { useState, useEffect, useRef } from 'react'
import Posts from './Posts'
import { data } from '../data'
import axios from 'axios'

const url = 'http://localhost:8080/api/v1/posts'

/*const NewPost = ({ posts, setPosts }) => {
  const [newPostTitle, setNewPostTitle] = useState('')
  const [newPostAuthor, setNewPostAuthor] = useState('')
  const handleNewPostTitleChange = (event) => {
    setNewPostTitle(event.target.value)
  }

  const handleNewPostAuthorChange = (event) => {
    setNewPostAuthor(event.target.value)
  }

  const handleNewPostSubmit = async (event) => {
    event.preventDefault()
    const newPost = {
      title: newPostTitle,
      author: newPostAuthor,
    }

    try {
      //const response = await axios.post(url, newPost)
      //setPosts([...posts, response.data])
      setPosts([...posts, newPost])

      setNewPostTitle('')
      setNewPostAuthor('')
    } catch (error) {
      console.error('Error adding new post:', error)
    }
  }

  return (
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
  )
}
export default NewPost*/

const NewPost = ({ posts, setPosts }) => {
  const newPostForm = useRef()

  const handleNewPostSubmit = async (event) => {
    event.preventDefault()
    const form = newPostForm.current
    const newPost = {
      title: form['title'].value,
      author: form['author'].value,
    }

    try {
      //const response = await axios.post(url, newPost)
      //setPosts([...posts, response.data])
      setPosts([...posts, newPost])
    } catch (error) {
      console.error('Error adding new post:', error)
    }
  }

  return (
    <div>
      <form ref={newPostForm} onSubmit={handleNewPostSubmit}>
        <div>
          <label>Title:</label>
          <input type="text" name={'title'} label={'title'} />
        </div>
        <div>
          <label>Author:</label>
          <input type="text" name={'author'} label={'author'} />
        </div>
        <button type="submit">Add Post</button>
      </form>
    </div>
  )
}
export default NewPost
