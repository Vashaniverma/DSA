class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        """
        Find the largest overlap between two binary images by sliding one over the other.
      
        The algorithm works by:
        1. Finding all '1' positions in both images
        2. For each pair of '1's (one from each image), calculating the translation vector
        3. Counting how many '1's align for each unique translation
        4. Returning the maximum count
      
        Args:
            img1: First n x n binary matrix
            img2: Second n x n binary matrix
          
        Returns:
            Maximum number of overlapping 1's after translation
        """
        n = len(img1)
      
        # Dictionary to count overlaps for each translation vector (row_shift, col_shift)
        translation_count = Counter()
      
        # Iterate through all positions in img1
        for row1 in range(n):
            for col1 in range(n):
                # If current position in img1 contains a 1
                if img1[row1][col1] == 1:
                    # Check all positions in img2
                    for row2 in range(n):
                        for col2 in range(n):
                            # If current position in img2 contains a 1
                            if img2[row2][col2] == 1:
                                # Calculate the translation vector needed to align
                                # these two 1's (from img1 position to img2 position)
                                translation_vector = (row1 - row2, col1 - col2)
                              
                                # Increment count for this translation
                                translation_count[translation_vector] += 1
      
        # Return the maximum overlap count, or 0 if no overlaps exist
        return max(translation_count.values()) if translation_count else 0
