import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/Available second hand vehicles, all in one place!/i);
  expect(linkElement).toBeInTheDocument();
});
