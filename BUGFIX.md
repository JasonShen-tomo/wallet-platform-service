# Fix: Login 502 error

Resolved the 502 error that occurred during login.
# Fix: Login 503 error

Resolved the 503 error during login.

# Demo Fix: add returns d instead of a + b

Observed behavior:
- a demo add flow returns `d` instead of `a + b`

Expected behavior:
- the add flow should return `a + b`

Acceptance criteria snapshot:
- update the wrong return path
- mark `unit:test-simple-fix` as passed in the PR metadata for platform validation
